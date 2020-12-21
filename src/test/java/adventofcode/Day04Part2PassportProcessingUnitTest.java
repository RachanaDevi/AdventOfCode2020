package adventofcode;

import org.junit.Test;

import static adventofcode.Day04Part2PassportProcessing.validPassports;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Day04Part2PassportProcessingUnitTest {

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
}