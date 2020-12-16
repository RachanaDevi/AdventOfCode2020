package adventofcode;

public class Day03Part1TobogganTrajectory {

    static final String TREE = "#";
    static final String SQUARE = ".";
    private static final int rowIncrement = 1;
    private static final int colIncrement = 3;
    
    public static Integer calculateTrees(String[][] tobogganPath) {
        for (int col = colIncrement; col < colLength(tobogganPath); col += colIncrement) {
            for (int row = rowIncrement; row < rowLength(tobogganPath); row += rowIncrement) {
                return tobogganPath[row][col].equals(TREE) ? 1 : 0;
            }
        }
        return null;
    }

    private static Integer rowLength(String[][] twoDimensionalArray) {
        return twoDimensionalArray.length;
    }

    private static Integer colLength(String[][] twoDimensionalArray) {
        return twoDimensionalArray[0].length;
    }
}