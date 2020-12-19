package adventofcode;

import org.junit.Test;

import static adventofcode.Day04Part1PassportProcessing.areValidFieldsPresent;
import static adventofcode.Day04Part1PassportProcessing.validPassportsCount;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Day04Part1PassportProcessingUnitTest {

    @Test
    public void shouldReturnFalseIfDoesntMatchThePasswordFields() {
        String[] passports = {""};
        assertThat(areValidFieldsPresent(passports[0]), is(false));
    }

    @Test
    public void shouldReturnTrueItMatchesWithoutNewlinesThePasswordFields() {
        String[] passports = {"ecl hgt pid eyr hcl byr iyr"};
        assertThat(areValidFieldsPresent(passports[0]), is(true));
    }

    @Test
    public void shouldReturnZeroValidPassport() {
        String[] invalidPassport = {"invalidPassportString"};
        assertThat(validPassportsCount(invalidPassport[0]), is(0));
    }

    @Test
    public void shouldReturnOneValidPassport() {
        String[] invalidPassport = {"ecl hgt pid eyr hcl byr iyr"};
        assertThat(validPassportsCount(invalidPassport[0]), is(1));
    }

    @Test
    public void shouldReturnOneValidPassportFromAnArrayOfPassports() {
        String[] invalidPassport = {"ecl hgt pid eyr hcl byr iyr"};
        assertThat(validPassportsCount(invalidPassport[0]), is(1));
    }
}