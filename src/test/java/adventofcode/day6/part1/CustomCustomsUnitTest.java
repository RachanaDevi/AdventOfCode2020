package adventofcode.day6.part1;


import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CustomCustomsUnitTest {

    @Test
    public void shouldGetGroups() throws IOException {
        var customCustoms = new CustomCustoms();
        String fileName = "src/test/resources/day_6_part_1_custom_customs_small.txt";

        String[] expectedGroups = {"abc", "abc", "abac", "aaaa", "b"};

        assertThat(customCustoms.groups(fileName), is(expectedGroups));
    }

    @Test
    public void shouldGetTotalGroups() throws IOException {
        var customCustoms = new CustomCustoms();
        String fileName = "src/test/resources/day_6_part_1_custom_customs_small.txt";

        assertThat(customCustoms.groups(fileName).length, is(5));
    }

    @Test
    public void shouldGetUniqueAnswersSum() throws IOException {
        var customCustoms = new CustomCustoms();
        String fileName = "src/test/resources/day_6_part_1_custom_customs_small.txt";

        assertThat(customCustoms.uniqueAnswerSum(fileName), is(11));
    }
}