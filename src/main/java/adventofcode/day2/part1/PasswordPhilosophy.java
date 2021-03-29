package adventofcode.day2.part1;

import java.util.List;

public class PasswordPhilosophy {

    public static boolean satisfiesPasswordConditions(String rule) {
        var count = 0;
        for (int i = 0; i < password(rule).length(); i++) {
            if (password(rule).charAt(i) == appliedAlphabet(rule)) {
                count++;
                if (count > upperLimit(rule)) return false;
            }
        }
        return count >= lowerLimit(rule);
    }

    private static int lowerLimit(String rule) {
        var range = range(rule);
        return Integer.parseInt(range[0]);
    }

    private static int upperLimit(String rule) {
        var range = range(rule);
        return Integer.parseInt(range[1]);
    }

    private static String[] range(String rule) {
        return stringByIndex(rules(rule), " ", 0).split("-");
    }

    private static char appliedAlphabet(String rule) {
        return stringByIndex(rules(rule), " ", 1).charAt(0);
    }

    private static String rules(String rule) {
        return stringByIndex(rule, ":", 0);
    }

    private static String password(String rule) {
        return stringByIndex(rule, ":", 1).trim();
    }

    private static String stringByIndex(String string, String delimiter, int index) {
        return string.split(delimiter)[index];
    }

    public static int correctPasswords(List<String> passwordRules) {
        return (int) passwordRules.stream().filter(PasswordPhilosophy::satisfiesPasswordConditions).count();
    }
}