package adventofcode;

import java.util.List;

public class Day02Part2PasswordPhilosophy {

    public static boolean satisfiesPassword(String rule) {
        var inputOutputSplit = rule.split(":");
        var charPosition = inputOutputSplit[0].split(" ")[0].split("-");
        var appliedAlphabet = inputOutputSplit[0].split(" ")[1].charAt(0);
        var firstPosition = Integer.parseInt(charPosition[0]) - 1;
        var secondPosition = Integer.parseInt(charPosition[1]) - 1;
        var count = 0;
        var password = inputOutputSplit[1].trim();
        final var passwordCharacters = password.split("");
        var bothNotInSamePosition = password.charAt(firstPosition) != password.charAt(secondPosition);
        var firstPositionHavingAppliedAlphabet = password.charAt(firstPosition) == appliedAlphabet;
        var secondPositionHavingAppliedAlphabet = password.charAt(secondPosition) == appliedAlphabet;
        var finalAnswer = (bothNotInSamePosition && (firstPositionHavingAppliedAlphabet
                || secondPositionHavingAppliedAlphabet));
        return finalAnswer;
    }


    public static int correctPasswords(List<String> passwordRules) {
        return (int) passwordRules.stream().filter(Day02Part2PasswordPhilosophy::satisfiesPassword).count();
    }
}