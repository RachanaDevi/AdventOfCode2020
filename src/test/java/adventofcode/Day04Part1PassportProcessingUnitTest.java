package adventofcode;

import org.junit.Test;

import java.io.IOException;

import static adventofcode.Day04Part1PassportProcessing.hasValidPassportFields;
import static adventofcode.Day04Part1PassportProcessing.validPassports;
import static adventofcode.utilities.Day04Part1PassportProcessingUtilities.getPassports;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Day04Part1PassportProcessingUnitTest {

    @Test
    public void shouldReturnFalseIfDoesntMatchThePasswordFields() {
        String[] passports = {""};
        assertThat(hasValidPassportFields(passports[0]), is(false));
    }

    @Test
    public void shouldReturnTrueItMatchesWithoutNewlinesThePasswordFields() {
        String[] passports = {"ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"};
        assertThat(hasValidPassportFields(passports[0]), is(true));
    }

    @Test
    public void shouldReturnZeroValidPassport() {
        String[] invalidPassport = {"invalidPassportString"};
        assertThat(validPassports(invalidPassport), is(0));
    }

    @Test
    public void shouldReturnOneValidPassport() {
        String[] validPassport = {"hcl:#ae17e1 iyr:2013 eyr:2024 ecl:brn pid:760753108 byr:1931 hgt:179cm"};
        assertThat(validPassports(validPassport), is(1));
    }

    @Test
    public void shouldReturnOneValidPassportFromAnArrayOfPassports() {
        String[] passports = {"ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm", "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884 hcl:#cfa07d byr:1929"};
        assertThat(validPassports(passports), is(1));
    }

    @Test
    public void shouldReturnTwoValidPassportsFromAFileContainingFourPassports() throws IOException {
        String[] passports = getPassports("src/test/resources/day_4_passport_processing_small.txt");

        assertThat(validPassports(passports), is(2));
    }

    @Test
    public void shouldReturn260ValidPassportsFromSampleInputFileContaining291Passports() throws IOException {
        String[] passports = getPassports("src/test/resources/day_4_passport_processing.txt");

        assertThat(validPassports(passports), is(260));
    }
}