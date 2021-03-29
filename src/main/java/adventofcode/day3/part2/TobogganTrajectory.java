package adventofcode.day3.part2;

public class TobogganTrajectory {

    static final String TREE = "#";
    static final String SQUARE = ".";

    public static Integer calculateTrees(String[][] tobogganPath, int rowIncrement, int colIncrement) {
        int totalTrees = 0;
        int col = colIncrement % colLength(tobogganPath);
        int row = rowIncrement;
        while (true) {
            if (row >= rowLength(tobogganPath)) {
                row = rowLength(tobogganPath) - 1;
            }
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