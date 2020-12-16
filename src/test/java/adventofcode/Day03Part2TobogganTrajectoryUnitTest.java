package adventofcode;


import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static adventofcode.Day03Part2TobogganTrajectory.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Day03Part2TobogganTrajectoryUnitTest {

    @Test
    public void shouldEncounterTreesGivenTheTobogganPathIs2x4AndRowIncrementAndColIncrementAreDifferentCases() {
        String[][] tobogganPath = {
                {SQUARE, SQUARE, SQUARE, SQUARE},
                {SQUARE, SQUARE, SQUARE, TREE},
        };

        assertThat(calculateTrees(tobogganPath, 1, 1), is(0));
        assertThat(calculateTrees(tobogganPath, 1, 3), is(1));
        assertThat(calculateTrees(tobogganPath, 1, 5), is(0));
        assertThat(calculateTrees(tobogganPath, 1, 7), is(1));
        assertThat(calculateTrees(tobogganPath, 2, 1), is(0));
    }

    @Test
    public void shouldEncounter1TreeAndLoopOverTheTobogganPathGivenThePathIs3x4() {
        String[][] tobogganPath = {
                {SQUARE, SQUARE, SQUARE, SQUARE},
                {SQUARE, TREE, SQUARE, SQUARE},
                {SQUARE, SQUARE, TREE, SQUARE},
        };

        assertThat(calculateTrees(tobogganPath, 1, 1), is(2));
        assertThat(calculateTrees(tobogganPath, 1, 3), is(1));
        assertThat(calculateTrees(tobogganPath, 1, 5), is(2));
        assertThat(calculateTrees(tobogganPath, 1, 7), is(1));
        assertThat(calculateTrees(tobogganPath, 2, 1), is(0));
    }


    @Test
    public void shouldEncounter3TreesAndLoopOverTheTobogganPathGivenThePathIs4x4() {
        String[][] tobogganPath = {
                {SQUARE, SQUARE, SQUARE, SQUARE},
                {SQUARE, SQUARE, SQUARE, TREE},
                {SQUARE, SQUARE, TREE, SQUARE},
                {SQUARE, TREE, SQUARE, SQUARE},
        };

        assertThat(calculateTrees(tobogganPath, 1, 1), is(1));
        assertThat(calculateTrees(tobogganPath, 1, 3), is(3));
        assertThat(calculateTrees(tobogganPath, 1, 5), is(1));
        assertThat(calculateTrees(tobogganPath, 1, 7), is(3));
        assertThat(calculateTrees(tobogganPath, 2, 1), is(0));
    }

    @Test
    public void shouldEncounter7TreesGivenTobogganPathFromInputFile() throws IOException {
        var tobogganPathArrayList = new ArrayList(Files
                .readAllLines(Paths
                        .get("src/test/resources/day_3_toboggan_trajectory_small.txt")));

        var tobogganPath = createTobogganPathFrom(tobogganPathArrayList);
        assertThat(calculateTrees(tobogganPath, 1, 1), is(2));
        assertThat(calculateTrees(tobogganPath, 1, 3), is(7));
        assertThat(calculateTrees(tobogganPath, 1, 5), is(3));
        assertThat(calculateTrees(tobogganPath, 1, 7), is(4));
        assertThat(calculateTrees(tobogganPath, 2, 1), is(2));
    }

    @Test
    public void shouldEncounter151TreesGivenTobogganPathFromInputFile() throws IOException {
        var tobogganPathArrayList = new ArrayList(Files
                .readAllLines(Paths
                        .get("src/test/resources/day3_toboggan_trajectory.txt")));

        var tobogganPath = createTobogganPathFrom(tobogganPathArrayList);
        assertThat(calculateTrees(tobogganPath, 1, 1), is(103));
        assertThat(calculateTrees(tobogganPath, 1, 3), is(151));
        assertThat(calculateTrees(tobogganPath, 1, 5), is(83));
        assertThat(calculateTrees(tobogganPath, 1, 7), is(99));
        assertThat(calculateTrees(tobogganPath, 2, 1), is(59));
    }

    private String[][] createTobogganPathFrom(ArrayList<String> rowTobogganPath) {
        var allRows = rowTobogganPath.toArray(new String[rowTobogganPath.size()]);
        String[][] finalArray = new String[allRows.length][allRows[0].length()];
        int row = 0;
        for (String a : rowTobogganPath) {
            var someArray = a.split("");
            finalArray[row++] = someArray;
        }
        return finalArray;
    }
}