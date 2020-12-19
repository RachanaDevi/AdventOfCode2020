package adventofcode;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static adventofcode.Day04Part1PassportProcessing.areValidFieldsPresent;
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
    public void shouldGetPassportsFromFileInStringHavingOnePassportDetail() throws IOException {
        var passports = getPassports("src/test/resources/day_4_passport_processing_one_correct_passport.txt");

        assertThat(passports.contains("\n"), is(false));
    }

    private String getPassports(String filePath) throws IOException {
        var fileReader = Files.readString(Paths.get(filePath));
        return fileReader.replace("\n", " ");
    }
}