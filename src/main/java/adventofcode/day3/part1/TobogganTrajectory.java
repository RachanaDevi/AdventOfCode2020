package adventofcode.day3.part1;

public class TobogganTrajectory {

    static final String TREE = "#";
    static final String SQUARE = ".";
    private static final int rowIncrement = 1;
    private static final int colIncrement = 3;

    public static Integer calculateTrees(String[][] tobogganPath) {
        int totalTrees = 0;
        int col = colIncrement;
        int row = rowIncrement;
        while (true) {
            if (tobogganPath[row][col].equals(TREE)) {
                totalTrees++;
            }
            if (row == rowLength(tobogganPath) - 1) {
                return totalTrees;
            }
            col = (col + colIncrement) % colLength(tobogganPath);
            row += rowIncrement;
        }
    }

    private static Integer rowLength(String[][] twoDimensionalArray) {
        return twoDimensionalArray.length;
    }

    private static Integer colLength(String[][] twoDimensionalArray) {
        return twoDimensionalArray[0].length;
    }
}