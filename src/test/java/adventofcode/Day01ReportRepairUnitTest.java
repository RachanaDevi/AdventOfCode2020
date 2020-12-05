package adventofcode;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Day01ReportRepairUnitTest {

    @Test
    public void shouldFindTwoNumberProductGivenListHasOnlyTwoNumber() {
        var numbers = new ArrayList<Integer>();
        numbers.add(1010);
        numbers.add(1010);
        assertThat(Day01ReportRepair.findTwoNumbersProductWhoseSumIs2020(numbers), is(1020100));
    }

    @Test
    public void shouldFindTwoNumbersProductGivenAListOfNumbers() {
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

    @Test
    public void shouldFindTwoNumbersGivenNumbersFromAnInputFile() throws IOException {
        var numbers = new ArrayList<>(Files.readAllLines(Paths.get("src/test/resources/day1_sum_2020.txt")));
        var intNumbers = numbers.stream().map(Integer::parseInt).collect(Collectors.toList());
        assertThat(Day01ReportRepair.findTwoNumbersProductWhoseSumIs2020(intNumbers), is(1006875));
    }

    @Test
    public void shouldFindThreeNumberProductGivenListHasOnlyTwoNumber() {
        var numbers = new ArrayList<Integer>();
        numbers.add(1000);
        numbers.add(1010);
        numbers.add(10);
        assertThat(Day01ReportRepair.findThreeNumbersProductWhoseSumIs2020(numbers), is(10100000));
    }

    @Test
    public void shouldFindThreeNumbersProductGivenAListOfNumbers() {
        var numbers = new ArrayList<Integer>();
        numbers.add(100);
        numbers.add(20);
        numbers.add(1900);
        numbers.add(1831);
        numbers.add(260);
        numbers.add(260);
        numbers.add(260);
        assertThat(Day01ReportRepair.findThreeNumbersProductWhoseSumIs2020(numbers), is(3800000));
    }

    @Test
    public void shouldFindThreeNumbersGivenNumbersFromAnInputFile() throws IOException {
        var numbers = new ArrayList<>(Files.readAllLines(Paths.get("src/test/resources/day1_sum_2020.txt")));
        var intNumbers = numbers.stream().map(Integer::parseInt).collect(Collectors.toList());
        assertThat(Day01ReportRepair.findThreeNumbersProductWhoseSumIs2020(intNumbers), is(165026160));
    }
}