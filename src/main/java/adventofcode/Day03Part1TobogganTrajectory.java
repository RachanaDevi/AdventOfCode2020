package adventofcode;

public class Day03Part1TobogganTrajectory {

    static final String TREE = "#";
    static final String SQUARE = ".";
    private static final int rowIncrement = 1;
    private static final int colIncrement = 3;

    public static Integer calculateTrees(String[][] tobogganPath) {
        if (rowLength(tobogganPath) == 1) {
            if (colLength(tobogganPath) > 3)
                return tobogganPath[0][3].equals(TREE) ? 1 : 0;
            return (tobogganPath[0][0].equals(TREE)) ? 1 : 0;
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