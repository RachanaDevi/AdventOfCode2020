package adventofcode;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static adventofcode.Day02Part2PasswordPhilosophy.correctPasswords;
import static adventofcode.Day02Part2PasswordPhilosophy.satisfiesPasswordPolicy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Day02Part2PasswordPhilosophyUnitTest {

    @Test
    public void shouldPassPasswordConditionGivenASingleInput() {
        var rule = "3-4 t: dtttt";

        assertThat(satisfiesPasswordPolicy(rule), is(false));
    }

    @Test
    public void shouldPassPasswordConditionsGivenAnArrayOfTwoPasswordRules() {
        var passwordRules = List.of("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc");

        assertThat(correctPasswords(passwordRules), is(1));
    }

    @Test
    public void shouldPassPasswordConditionsGivenManyPasswordRulesFromAFile() throws IOException {
        var passwordRules = new ArrayList<>(Files
                .readAllLines(Paths
                        .get("src/test/resources/day2_password_philosophy.txt")));

        assertThat(correctPasswords(passwordRules), is(352));
    }
}