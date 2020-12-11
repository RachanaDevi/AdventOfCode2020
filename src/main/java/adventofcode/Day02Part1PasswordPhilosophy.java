package adventofcode;

import java.util.List;

public class Day02Part1PasswordPhilosophy {

    public static boolean satisfiesPassword(String rule) {
        var inputOutputSplit = rule.split(":");
        var range = inputOutputSplit[0].split(" ")[0].split("-");
        var appliedAlphabet = inputOutputSplit[0].split(" ")[1].charAt(0);
        var lowerLimit = Integer.parseInt(range[0]);
        var upperLimit = Integer.parseInt(range[1]);
        var count = 0;
        var password = inputOutputSplit[1].trim();
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == appliedAlphabet) {
                count++;
                if (count > upperLimit) return false;
            }
        }
        return count >= lowerLimit;
    }

    public static int correctPasswords(List<String> passwordRules) {
        return (int) passwordRules.stream().filter(Day02Part1PasswordPhilosophy::satisfiesPassword).count();
    }
}