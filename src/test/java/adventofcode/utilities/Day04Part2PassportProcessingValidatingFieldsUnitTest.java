package adventofcode.utilities;

import org.junit.Test;

import static adventofcode.utilities.Day04Part2PassportProcessingValidatingFields.isValidPassportField;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Day04Part2PassportProcessingValidatingFieldsUnitTest {

    @Test
    public void shouldReturnFalseIfBirthYearIsLessThan1920() {
        var invalidBirthYear = "byr:1919";
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
    public void shouldReturnFalseIfExpirationYearIsLessThan2020() {
        var expirationYear = "eyr:2019";
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

    @Test
    public void shouldReturnFalseForInvalidHairColor() {
        var invalidHairColor = "hcl:#fg012k";
        assertThat(isValidPassportField(invalidHairColor), is(false));
    }

    @Test
    public void shouldReturnFalseHavingHairColorLengthLessThan6() {
        var invalidHairColor = "hcl:#ff012";
        assertThat(isValidPassportField(invalidHairColor), is(false));
    }

    @Test
    public void shouldReturnTrueHavingValidHairColor() {
        var invalidHairColor = "hcl:#fffaa0";
        assertThat(isValidPassportField(invalidHairColor), is(true));
    }

    @Test
    public void shouldReturnFalseForInvalidEyeColor() {
        var invalidEyeColor = "ecl:invalid";
        assertThat(isValidPassportField(invalidEyeColor), is(false));
    }

    @Test
    public void shouldReturnTrueForValidEyeColorWithSpace() {
        var invalidEyeColor = "ecl:brn ";
        assertThat(isValidPassportField(invalidEyeColor), is(true));
    }

    @Test
    public void shouldReturnTrueGivenHeightIsGreaterThan59inches() {
        var validHeight = "hgt:60in";
        assertThat(isValidPassportField(validHeight), is(true));
    }

    @Test
    public void shouldReturnTrueGivenHeightIsLessThan77inches() {
        var validHeight = "hgt:76in";
        assertThat(isValidPassportField(validHeight), is(true));
    }

    @Test
    public void shouldReturnFalseGivenHeightIsLessThan59inches() {
        var invalidHeight = "hgt:58in";
        assertThat(isValidPassportField(invalidHeight), is(false));
    }

    @Test
    public void shouldReturnFalseGivenHeightIsGreaterThan76inches() {
        var invalidHeight = "hgt:77in";
        assertThat(isValidPassportField(invalidHeight), is(false));
    }

    @Test
    public void shouldReturnTrueGivenHeightIsGreaterThan150cm() {
        var validHeight = "hgt:151cm";
        assertThat(isValidPassportField(validHeight), is(true));
    }

    @Test
    public void shouldReturnTrueGivenHeightIsLessThan194cm() {
        var validHeight = "hgt:193cm";
        assertThat(isValidPassportField(validHeight), is(true));
    }

    @Test
    public void shouldReturnFalseGivenHeightIsLessThan150cm() {
        var invalidHeight = "hgt:149cm";
        assertThat(isValidPassportField(invalidHeight), is(false));
    }

    @Test
    public void shouldReturnFalseGivenHeightIsGreaterThan193cm() {
        var invalidHeight = "hgt:194cm";
        assertThat(isValidPassportField(invalidHeight), is(false));
    }
}