package adventofcode.day5;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Day05Part1BinaryBoardingUnitTest {

    @Test
    public void shouldGetCorrectRangeForRowNumberOfTwoLetters() {
        var rowNumber = "FB";
        final var binaryBoarding = new Day05Part1BinaryBoarding();
        binaryBoarding.getRowNumber(rowNumber);

        Assertions.assertAll(() -> assertThat(binaryBoarding.lowerLimit, is(32)),
                () -> assertThat(binaryBoarding.upperLimit, is(63)));
    }

    @Test
    public void shouldGetCorrectRangeForRowNumberOfThreeLetters() {
        var rowNumber = "FBF";
        final var binaryBoarding = new Day05Part1BinaryBoarding();
        binaryBoarding.getRowNumber(rowNumber);

        Assertions.assertAll(() -> assertThat(binaryBoarding.lowerLimit, is(32)),
                () -> assertThat(binaryBoarding.upperLimit, is(47)));
    }

    @Test
    public void shouldGetCorrectRangeForRowNumberOfFourLetters() {
        var rowNumber = "FBFB";
        final var binaryBoarding = new Day05Part1BinaryBoarding();
        binaryBoarding.getRowNumber(rowNumber);

        Assertions.assertAll(() -> assertThat(binaryBoarding.lowerLimit, is(40)),
                () -> assertThat(binaryBoarding.upperLimit, is(47)));
    }

    @Test
    public void shouldReturn44AsRowNumberSeatRowNumberIsSevenLetters() {
        var rowNumber = "FBFBBFF";
        final var binaryBoarding = new Day05Part1BinaryBoarding();

        assertThat(binaryBoarding.getRowNumber(rowNumber), is(44));
    }


    @Test
    public void shouldGetCorrectRangeForColNumberOfOneLetter() {
        var colNumber = "R";
        final var binaryBoarding = new Day05Part1BinaryBoarding();
        binaryBoarding.getColNumber(colNumber);

        Assertions.assertAll(() -> assertThat(binaryBoarding.lowerLimit, is(4)),
                () -> assertThat(binaryBoarding.upperLimit, is(7)));
    }

    @Test
    public void shouldGetCorrectRangeForColNumberOfTwoLetters() {
        var colNumber = "RL";
        final var binaryBoarding = new Day05Part1BinaryBoarding();
        binaryBoarding.getColNumber(colNumber);

        Assertions.assertAll(() -> assertThat(binaryBoarding.lowerLimit, is(4)),
                () -> assertThat(binaryBoarding.upperLimit, is(5)));
    }

    @Test
    public void shouldGetCorrectRangeForColNumberOfThreeLetters() {
        var colNumber = "RLR";
        final var binaryBoarding = new Day05Part1BinaryBoarding();
        binaryBoarding.getColNumber(colNumber);

        Assertions.assertAll(() -> assertThat(binaryBoarding.lowerLimit, is(5)),
                () -> assertThat(binaryBoarding.upperLimit, is(5)));
    }

    @Test
    public void shouldReturn5AsColNumberGivenSeatColNumberIsThreeLetters() {
        var colNumber = "RLR";
        final var binaryBoarding = new Day05Part1BinaryBoarding();

        assertThat(binaryBoarding.getColNumber(colNumber), is(5));
    }
}