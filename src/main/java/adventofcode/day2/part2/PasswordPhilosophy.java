package adventofcode.day2.part2;

import java.util.List;

public class PasswordPhilosophy {

    public static int correctPasswords(List<String> passwordRules) {
        return (int) passwordRules.stream().filter(PasswordPhilosophy::satisfiesPasswordPolicy).count();
    }

    public static boolean satisfiesPasswordPolicy(String passwordPolicyAndPassword) {
        return (bothCharactersNotInSamePosition(passwordPolicyAndPassword)
                && (firstPositionHavingAppliedAlphabet(passwordPolicyAndPassword)
                || secondPositionHavingAppliedAlphabet(passwordPolicyAndPassword)));
    }

    private static boolean secondPositionHavingAppliedAlphabet(String passwordPolicyAndPassword) {
        final var secondPosition = getPosition(passwordPolicyAndPassword, 1);
        return password(passwordPolicyAndPassword).charAt(secondPosition) == appliedAlphabet(passwordPolicyAndPassword);
    }

    private static boolean firstPositionHavingAppliedAlphabet(String passwordPolicyAndPassword) {
        final var firstPosition = getPosition(passwordPolicyAndPassword, 0);
        return password(passwordPolicyAndPassword).charAt(firstPosition) == appliedAlphabet(passwordPolicyAndPassword);
    }

    private static boolean bothCharactersNotInSamePosition(String passwordPolicyAndPassword) {
        final var firstPosition = getPosition(passwordPolicyAndPassword, 0);
        final var secondPosition = getPosition(passwordPolicyAndPassword, 1);

        return password(passwordPolicyAndPassword).charAt(firstPosition)
                != password(passwordPolicyAndPassword).charAt(secondPosition);
    }

    private static int getPosition(String passwordPolicyAndPassword, int position) {
        var passwordPolicy = passwordPolicyAndPassword(passwordPolicyAndPassword);
        var charPositions = getCharPositionsFrom(passwordPolicy)[0];
        
        return Integer.parseInt(charPositions.split("-")[position]) - 1;
    }

    private static String[] getCharPositionsFrom(String[] positionsAndAppliedAlphabet) {
        var positions = positionsAndAppliedAlphabet[0];
        return positions.split(" ");
    }

    private static String password(String passwordPolicyAndPassword) {
        var password = passwordPolicyAndPassword(passwordPolicyAndPassword)[1];
        return password.trim();
    }

    private static char appliedAlphabet(String passwordPolicyAndPassword) {
        var passwordPolicy = passwordPolicyAndPassword(passwordPolicyAndPassword)[0];
        var charPositionsAndAppliedAlphabet = passwordPolicy.split(" ");

        return charPositionsAndAppliedAlphabet[1].charAt(0);
    }

    private static String[] passwordPolicyAndPassword(String passwordPolicyAndAppliedAlphabet) {
        return passwordPolicyAndAppliedAlphabet.split(":");
    }
}