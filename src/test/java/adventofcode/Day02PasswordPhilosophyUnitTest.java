package adventofcode;

import org.junit.Test;

import java.util.List;

import static adventofcode.Day02PasswordPhilosophy.correctPasswords;
import static adventofcode.Day02PasswordPhilosophy.satisfiesPassword;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Day02PasswordPhilosophyUnitTest {
    @Test
    public void shouldPassPasswordConditionsGivenSingleInput() {
        var rule = "3-4 t: dtttt";

        assertThat(satisfiesPassword(rule), is(true));
    }

    @Test
    public void shouldPassPasswordConditionsGivenAnArrayOfTwoPasswordRules() {
        var passwordRules = List.of("3-4 t: dttt", "3-4 h: vhh");

        assertThat(correctPasswords(passwordRules), is(1));
    }
}