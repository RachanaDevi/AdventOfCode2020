package adventofcode.utilities;

import org.junit.Test;

import java.io.IOException;

import static adventofcode.utilities.Day04Part1PassportProcessingUtilities.getPassports;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Day04Part1PassportProcessingUtilitiesUnitTest {

    @Test
    public void shouldGetPassportsFromFileInStringHavingOnePassportDetail() throws IOException {
        var passports = getPassports("src/test/resources/day_4_passport_processing_one_correct_passport.txt");

        assertThat(passports.contains("\n"), is(false));
    }
}