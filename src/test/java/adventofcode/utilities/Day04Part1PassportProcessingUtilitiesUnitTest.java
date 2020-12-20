package adventofcode.utilities;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

import static adventofcode.utilities.Day04Part1PassportProcessingUtilities.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Day04Part1PassportProcessingUtilitiesUnitTest {

    @Test
    public void shouldGetPassportsFromFileHavingOnePassportDetail() throws IOException {
        var passports = getPassports("src/test/resources/day_4_passport_processing_one_correct_passport.txt");

        assertThat(passports[0], is("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"));
    }

    @Test
    public void shouldGetPassportsFromFileHavingTwoPassportDetails() throws IOException {
        var passports = getPassports("src/test/resources/day_4_passport_processing_one_correct_passport_from_two_passport_details.txt");

        Assertions.assertAll(
                () -> assertThat(passports[0], is("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm")),
                () -> assertThat(passports[1], is("hcl:#ae17e1 iyr:2013 eyr:2024 ecl:brn pid:760753108 byr:1931 hgt:179cm"))
        );
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