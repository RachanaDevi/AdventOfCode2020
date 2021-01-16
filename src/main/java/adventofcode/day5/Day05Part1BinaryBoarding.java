package adventofcode.day5;

public class Day05Part1BinaryBoarding {

    int lowerLimit;
    int upperLimit;

    public int rowNumber(String rowNumber) {
        return getLastNumber(rowNumber, 0, 127, "F");
    }

    public int colNumber(String colNumber) {
        return getLastNumber(colNumber, 0, 7, "L");
    }

    private int getLastNumber(String steps, int lowerLimit, int upperLimit, String firstHalf) {
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
}
