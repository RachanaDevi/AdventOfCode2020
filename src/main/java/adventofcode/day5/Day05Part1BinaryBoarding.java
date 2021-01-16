package adventofcode.day5;

public class Day05Part1BinaryBoarding {

    int lowerLimit;
    int upperLimit;


    public int getRowNumber(String rowNumber) {
        return getSeatFrom(rowNumber, 0, 127, "F");
    }

    public int getColNumber(String colNumber) {
        return getSeatFrom(colNumber, 0, 7, "L");
    }

    private int getSeatFrom(String seatNumber, int lowerLimit, int upperLimit, String firstHalf) {
        var seatNumbers = seatNumber.split("");
        for (String seatNum : seatNumbers) {
            if (seatNum.equals(firstHalf)) {
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
