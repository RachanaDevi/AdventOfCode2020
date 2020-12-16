package adventofcode;


import org.junit.Test;

import static adventofcode.Day03Part1TobogganTrajectory.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Day03Part1TobogganTrajectoryUnitTest {

    @Test
    public void shouldEncounter1TreeGivenTheTobogganPathIs2x4() {
        String[][] tobogganPath = {
                {SQUARE, SQUARE, SQUARE, SQUARE},
                {SQUARE, SQUARE, SQUARE, TREE},
        };

        assertThat(calculateTrees(tobogganPath), is(1));
    }
}