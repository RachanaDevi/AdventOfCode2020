package adventofcode.utilities;

public class Day04Part2PassportProcessingValidatingFields {

    private static final String COLON_SEPARATOR = ":";

    public static boolean isValidPassportField(String passportField) {

        String fieldKey = passportField.substring(0, passportField.indexOf(COLON_SEPARATOR)).trim();
        String fieldValue = passportField.substring(passportField.indexOf(COLON_SEPARATOR) + 1).trim();
        return validate(fieldKey, fieldValue);
    }

    private static boolean validate(String key, String value) {
        return switch (key) {
            case "byr" -> hasYearRange(value, 1920, 2002);
            case "iyr" -> hasYearRange(value, 2010, 2020);
            case "eyr" -> hasYearRange(value, 2020, 2030);
            case "hcl" -> value.matches("^#[a-f0-9]{6}$");
            case "ecl" -> value.matches("^(amb|blu|brn|gry|grn|hzl|oth)$");
            case "pid" -> value.matches("[0-9]{9}");
            default -> false;
        };
    }

    private static boolean hasYearRange(String value, int startYear, int endYear) {
        if (!isYear(value)) return false;
        return Integer.parseInt(value) > startYear && Integer.parseInt(value) <= endYear;
    }

    private static boolean isYear(String value) {
        return value != null && value.matches("[0-9]{4}");
    }
}