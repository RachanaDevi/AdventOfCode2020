package adventofcode.day3.part1;


import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static adventofcode.day3.part1.TobogganTrajectory.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TobogganTrajectoryUnitTest {

    @Test
    public void shouldEncounter1TreeGivenTheTobogganPathIs2x4() {
        String[][] tobogganPath = {
                {SQUARE, SQUARE, SQUARE, SQUARE},
                {SQUARE, SQUARE, SQUARE, TREE},
        };

        assertThat(calculateTrees(tobogganPath), is(1));
    }

    @Test
    public void shouldEncounter1TreeAndLoopOverTheTobogganPathGivenThePathIs3x4() {
        String[][] tobogganPath = {
                {SQUARE, SQUARE, SQUARE, SQUARE},
                {SQUARE, SQUARE, SQUARE, SQUARE},
                {SQUARE, SQUARE, TREE, SQUARE},
        };

        assertThat(calculateTrees(tobogganPath), is(1));
    }


    @Test
    public void shouldEncounter3TreesAndLoopOverTheTobogganPathGivenThePathIs4x4() {
        String[][] tobogganPath = {
                {SQUARE, SQUARE, SQUARE, SQUARE},
                {SQUARE, SQUARE, SQUARE, TREE},
                {SQUARE, SQUARE, TREE, SQUARE},
                {SQUARE, TREE, SQUARE, SQUARE},
        };

        assertThat(calculateTrees(tobogganPath), is(3));
    }

    @Test
    public void shouldEncounter7TreesGivenTobogganPathFromInputFile() throws IOException {
        var tobogganPathArrayList = new ArrayList(Files
                .readAllLines(Paths
                        .get("src/test/resources/day_3_toboggan_trajectory_small.txt")));

        var tobogganPath = createTobogganPathFrom(tobogganPathArrayList);
        assertThat(calculateTrees(tobogganPath), is(7));
    }

    @Test
    public void shouldEncounter151TreesGivenTobogganPathFromInputFile() throws IOException {
        var tobogganPathArrayList = new ArrayList(Files
                .readAllLines(Paths
                        .get("src/test/resources/day3_toboggan_trajectory.txt")));

        var tobogganPath = createTobogganPathFrom(tobogganPathArrayList);
        assertThat(calculateTrees(tobogganPath), is(151));
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