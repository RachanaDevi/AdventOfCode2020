package adventofcode;

import org.junit.Test;

import static adventofcode.Day02Part2PasswordPhilosophy.satisfiesPassword;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Day02Part2PasswordPhilosophyUnitTest {

    @Test
    public void shouldPassPasswordConditionGivenASingleInput() {
        var rule = "3-4 t: dtttt";

        assertThat(satisfiesPassword(rule), is(false));
    }
}