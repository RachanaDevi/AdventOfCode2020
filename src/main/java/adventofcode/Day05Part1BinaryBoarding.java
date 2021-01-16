package adventofcode;

public class Day05Part1BinaryBoarding {

    int lowerRange;
    int upperRange;

    public Day05Part1BinaryBoarding() {
        this.lowerRange = 0;
        this.upperRange = 127;
    }

    public int getRowNumber(String rowNumber) {
        var rowNumbers = rowNumber.split("");
        for (String rowNum : rowNumbers) {
            if (rowNum.equals("F")) {
                upperRange = (upperRange - ((upperRange - lowerRange) / 2)) - 1;
            } else {
                lowerRange = (lowerRange + ((upperRange - lowerRange) / 2)) + 1;
            }
        }
        return lowerRange;
    }
}
