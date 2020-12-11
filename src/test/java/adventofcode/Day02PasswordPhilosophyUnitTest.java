package adventofcode;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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

    @Test
    public void shouldPassPasswordConditionsGivenManyPasswordRulesFromAFile() throws IOException {
        var passwordRules = new ArrayList<>(Files
                .readAllLines(Paths
                        .get("src/test/resources/day2_password_philosophy.txt")));

        assertThat(correctPasswords(passwordRules), is(586));
    }
}