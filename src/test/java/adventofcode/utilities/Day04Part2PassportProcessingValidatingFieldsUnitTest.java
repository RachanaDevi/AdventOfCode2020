package adventofcode.utilities;

import org.junit.Test;

import static adventofcode.utilities.Day04Part2PassportProcessingValidatingFields.validateField;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Day04Part2PassportProcessingValidatingFieldsUnitTest {

    @Test
    public void shouldReturnFalseIfBirthYearIsLessThan1920() {
        var invalidBirthYear = "byr:1919";
        assertThat(validateField(invalidBirthYear), is(false));
    }

    @Test
    public void shouldReturnFalseIfBirthYearIsMoreThan2002() {
        var invalidBirthYear = "byr:2003";
        assertThat(validateField(invalidBirthYear), is(false));
    }

    @Test
    public void shouldReturnTrueIfBirthYearIsBetween1920And2002() {
        var birthYear = "byr:1961";
        assertThat(validateField(birthYear), is(true));
    }

    @Test
    public void shouldReturnTrueIfIssueYearIsBetween2010And2020() {
        var invalidBirthYear = "iyr:2015";
        assertThat(validateField(invalidBirthYear), is(true));
    }
}