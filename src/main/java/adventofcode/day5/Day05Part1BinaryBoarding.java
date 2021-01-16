package adventofcode.day5;

public class Day05Part1BinaryBoarding {

    int lowerLimit;
    int upperLimit;


    public int getRowNumber(String rowNumber) {
        return getSeatFrom(rowNumber, 0, 127);
    }

    private int getSeatFrom(String seatNumber, int lowerLimit, int upperLimit) {
        var seatNumbers = seatNumber.split("");
        for (String seatNum : seatNumbers) {
            if (seatNum.equals("F")) {
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
