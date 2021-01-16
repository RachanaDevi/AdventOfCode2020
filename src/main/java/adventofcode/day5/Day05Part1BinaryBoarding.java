package adventofcode.day5;

import java.util.ArrayList;
import java.util.Comparator;

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

    public int maxSeatNumber(ArrayList<String> seatNumbers) {
        var seatNumbersInt = seatNumbers
                .stream()
                .map(this::seatNumber)
                .collect(toList());

        return seatNumbersInt.stream().max(Comparator.comparing(v -> v)).get();
    }
}
