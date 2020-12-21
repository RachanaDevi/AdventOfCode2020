package adventofcode.utilities;

import org.junit.Test;

import static adventofcode.utilities.Day04Part2PassportProcessingValidatingFields.isValidPassportField;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Day04Part2PassportProcessingValidatingFieldsUnitTest {

    @Test
    public void shouldReturnFalseIfBirthYearIsLessThan1921() {
        var invalidBirthYear = "byr:1920";
        assertThat(isValidPassportField(invalidBirthYear), is(false));
    }

    @Test
    public void shouldReturnFalseIfBirthYearIsMoreThan2002() {
        var invalidBirthYear = "byr:2003";
        assertThat(isValidPassportField(invalidBirthYear), is(false));
    }

    @Test
    public void shouldReturnTrueIfBirthYearIsBetween1920And2002() {
        var birthYear = "byr:1961";
        assertThat(isValidPassportField(birthYear), is(true));
    }

    @Test
    public void shouldReturnTrueIfIssueYearIsBetween2010And2020() {
        var issueYear = "iyr:2015";
        assertThat(isValidPassportField(issueYear), is(true));
    }

    @Test
    public void shouldReturnFalseIfExpirationYearIsBetween2021And2030() {
        var expirationYear = "eyr:2020";
        assertThat(isValidPassportField(expirationYear), is(false));
    }

    @Test
    public void shouldReturnFalseForInvalidPassportID() {
        var invalidPassportId = "pid:";
        assertThat(isValidPassportField(invalidPassportId), is(false));
    }

    @Test
    public void shouldReturnTrueForValidPassportID() {
        var passportId = "pid:023456789";
        assertThat(isValidPassportField(passportId), is(true));
    }
}