package adventofcode;

public class Day03Part1TobogganTrajectory {

    static final String TREE = "#";
    static final String SQUARE = ".";
    private static final int rowIncrement = 1;
    private static final int colIncrement = 3;

    public static Integer calculateTrees(String[][] tobogganPath) {
        int totalTrees = 0;
        for (int col = colIncrement; ; ) {
            for (int row = rowIncrement; ; row += rowIncrement) {
                if (tobogganPath[row][col].equals(TREE)) {
                    totalTrees++;
                }
                if (row == rowLength(tobogganPath) - 1) {
                    return totalTrees;
                }
                col = (col + colIncrement) % colLength(tobogganPath);
            }
        }
    }

    private static Integer rowLength(String[][] twoDimensionalArray) {
        return twoDimensionalArray.length;
    }

    private static Integer colLength(String[][] twoDimensionalArray) {
        return twoDimensionalArray[0].length;
    }
}