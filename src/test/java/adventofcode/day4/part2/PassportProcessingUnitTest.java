package adventofcode.day4.part2;

import org.junit.Test;

import java.io.IOException;

import static adventofcode.day4.part2.PassportProcessing.validPassports;
import static adventofcode.day4.part1.utility.PassportProcessingUtility.getPassports;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PassportProcessingUnitTest {

    @Test
    public void shouldReturnZeroValidPassportsGivenOneInvalidPassports() {
        String[] invalidPassports = {"eyr:1972 cid:100 hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926"};

        assertThat(validPassports(invalidPassports), is(0));
    }

    @Test
    public void shouldReturnOneValidPassportGivenTwoPassports() {
        String[] passports = {"eyr:1972 cid:100 hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926",
                "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980 hcl:#623a2f"};

        assertThat(validPassports(passports), is(1));
    }

    @Test
    public void shouldReturnFourValidPassportsFromEightPassportsInAFile() throws IOException {
        String[] passports = getPassports("src/test/resources/day_4_2_passport_processing_small.txt");

        assertThat(validPassports(passports), is(4));
    }

    @Test
    public void shouldReturn153ValidPassportsFrom291PassportsInAFile() throws IOException {
        String[] passports = getPassports("src/test/resources/day_4_passport_processing.txt");

        assertThat(validPassports(passports), is(153));
    }
}