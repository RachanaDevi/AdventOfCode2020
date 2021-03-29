package adventofcode.day2.part1;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static adventofcode.day2.part1.PasswordPhilosophy.correctPasswords;
import static adventofcode.day2.part1.PasswordPhilosophy.satisfiesPasswordConditions;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PasswordPhilosophyUnitTest {
    @Test
    public void shouldPassPasswordConditionsGivenSingleInput() {
        var rule = "3-4 t: dtttt";

        assertThat(satisfiesPasswordConditions(rule), is(true));
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