package adventofcode;

import org.junit.Test;

import static adventofcode.Day04Part1PassportProcessing.areValidFieldsPresent;
import static adventofcode.Day04Part1PassportProcessing.validPassports;
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
        assertThat(validPassports(invalidPassport), is(0));
    }

    @Test
    public void shouldReturnOneValidPassport() {
        String[] validPassport = {"ecl hgt pid eyr hcl byr iyr"};
        assertThat(validPassports(validPassport), is(1));
    }

    @Test
    public void shouldReturnOneValidPassportFromAnArrayOfPassports() {
        String[] passports = {"hcl byr iyr ecl hgt pid eyr ", "ecl hgt pid eyr hcl iyr"};
        assertThat(validPassports(passports), is(1));
    }
}