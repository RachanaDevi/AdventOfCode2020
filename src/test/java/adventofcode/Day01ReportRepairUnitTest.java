package adventofcode;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Day01ReportRepairUnitTest {

    @Test
    public void shouldFindTwoNumberResultingIn2020() {
        var numbers = new ArrayList<Integer>();
        numbers.add(1010);
        numbers.add(1010);
        assertThat(Day01ReportRepair.findTwoNumbersProductWhoseSumIs2020(numbers), is(1020100));
    }

    @Test
    public void shouldShowCorrectAnswerFromAListOfNumbers() {
        var numbers = new ArrayList<Integer>();
        numbers.add(10);
        numbers.add(189);
        numbers.add(910);
        numbers.add(1831);
        numbers.add(260);
        numbers.add(260);
        numbers.add(260);
        assertThat(Day01ReportRepair.findTwoNumbersProductWhoseSumIs2020(numbers), is(346059));
    }
}