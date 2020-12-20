package adventofcode.utilities;

import org.junit.Test;

import java.io.IOException;

import static adventofcode.utilities.Day04Part1PassportProcessingUtilities.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Day04Part1PassportProcessingUtilitiesUnitTest {

    @Test
    public void shouldGetPassportsFromFileInStringHavingOnePassportDetail() throws IOException {
        var passports = getPassports("src/test/resources/day_4_passport_processing_one_correct_passport.txt");

        assertThat(passports.contains("\n"), is(false));
    }

    @Test
    public void shouldGetPassportsFromFileInStringHavingTwoPassportDetails() throws IOException {
        var passports = getPassports("src/test/resources/day_4_passport_processing_one_correct_passport_and_two_passport_details.txt");
        System.out.println(passports);

        assertThat(passports.contains("\n"), is(false));
    }

    @Test
    public void shouldSplitAStringHavingDelimiterAsTwoLines() {
        String stringHavingTwoNewLines = "firstString\n" +
                "\n" +
                "secondString";

        assertThat(splitByTwoNewlines(stringHavingTwoNewLines), is(new String[]{"firstString", "secondString"}));
    }

    @Test
    public void shouldRemoveNewlinesInAString() {
        String[] stringHavingTwoNewLines = {"firstString\n"};

        assertThat(removeNewLines(stringHavingTwoNewLines)[0].contains("\n"), is(false));
    }
}