package adventofcode;

public class Day02Part2PasswordPhilosophy {

    public static boolean satisfiesPassword(String rule) {
        var inputOutputSplit = rule.split(":");
        var charPosition = inputOutputSplit[0].split(" ")[0].split("-");
        var appliedAlphabet = inputOutputSplit[0].split(" ")[1].charAt(0);
        var firstPosition = Integer.parseInt(charPosition[0]);
        var secondPosition = Integer.parseInt(charPosition[1]);
        var count = 0;
        var password = inputOutputSplit[1].trim();
        final var passwordCharacters = password.split("");
        return (password.charAt(firstPosition) != password.charAt(secondPosition)
                && (
                password.charAt(firstPosition) == appliedAlphabet
                        ||
                        password.charAt(secondPosition) == appliedAlphabet));

    }

}
