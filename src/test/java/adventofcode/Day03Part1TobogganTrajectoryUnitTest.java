package adventofcode;


import org.junit.Test;

import static adventofcode.Day03Part1TobogganTrajectory.SQUARE;
import static adventofcode.Day03Part1TobogganTrajectory.TREE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Day03Part1TobogganTrajectoryUnitTest {

    @Test
    public void shouldEncounter1TreeGivenTheTobogganPathIs1x1() {
        String[][] tobogganPath = {
                {TREE},
        };

        assertThat(Day03Part1TobogganTrajectory.calculateTrees(tobogganPath), is(1));
    }

    @Test
    public void shouldEncounter1TreeGivenTheTobogganPathIs1x4() {
        String[][] tobogganPath = {
                {SQUARE, SQUARE, SQUARE, TREE},
        };

        assertThat(Day03Part1TobogganTrajectory.calculateTrees(tobogganPath), is(1));
    }
}