package adventofcode.day5;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Day05Part1BinaryBoarding {

    int lowerLimit;
    int upperLimit;

    public int rowNumber(String rowNumber) {
        return getLastNumber(rowNumber, 127, "F");
    }

    public int colNumber(String colNumber) {
        return getLastNumber(colNumber, 7, "L");
    }

    private int getLastNumber(String steps, int upperLimit, String firstHalf) {
        int lowerLimit = 0;
        var stepArray = steps.split("");
        for (String step : stepArray) {
            if (step.equals(firstHalf)) {
                upperLimit = (upperLimit - ((upperLimit - lowerLimit) / 2)) - 1;
            } else {
                lowerLimit = (lowerLimit + ((upperLimit - lowerLimit) / 2)) + 1;
            }
        }
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        return lowerLimit;
    }

    public int seatNumber(String seatNumber) {
        int rowNumber = rowNumber(seatNumber.substring(0, 7));
        int colNumber = colNumber(seatNumber.substring(7, 10));
        return (rowNumber * 8) + colNumber;
    }

    public int maxSeatNumber(ArrayList<String> seatNumbers) throws IOException {
        var seatNumbersInt = seatNumbers
                .stream()
                .map(this::seatNumber)
                .sorted()
                .collect(toList());

        seatNumberAndIdIntoFile(seatNumbers);

        return seatNumbersInt.stream().max(Comparator.comparing(v -> v)).get();
    }

    private void seatNumberAndIdIntoFile(ArrayList<String> seatNumbers) throws IOException {
        Map<Integer, String> seatIdToSeatNumberMapping = seatIdToSeatNumberMapping(seatNumbers);

        FileWriter writer = new FileWriter("src/test/resources/day_5_all_seat_numbers.txt");
        for (Map.Entry<Integer, String> seatNumberEntry : seatIdToSeatNumberMapping.entrySet()) {

            writer.write(String.format("%d %s\n", seatNumberEntry.getKey(), seatNumberEntry.getValue()));
        }
        writer.close();
    }

    private Map<Integer, String> seatIdToSeatNumberMapping(ArrayList<String> seatNumbers) {
        return seatNumbers
                .stream()
                .collect(
                        Collectors.toMap(this::seatNumber, user -> user)
                );
    }

    public int missingSeatNumber(ArrayList<String> seatNumbers) {
        var seatNumbersList = new ArrayList<>(seatIdToSeatNumberMapping(seatNumbers).keySet());
        var missingSeatNumber = 0;
        for (int i = 0; i < seatNumbersList.size() - 1; i++) {
            if (seatNumbersList.get(i).equals(seatNumbersList.get(i + 1) - 1)) {
                continue;
            }
            missingSeatNumber = seatNumbersList.get(i) + 1;
        }
        return missingSeatNumber;
    }
}
