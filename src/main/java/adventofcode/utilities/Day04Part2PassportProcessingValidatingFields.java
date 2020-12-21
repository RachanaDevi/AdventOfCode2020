package adventofcode.utilities;

public class Day04Part2PassportProcessingValidatingFields {

    private static final String COLON_SEPARATOR = ":";

    public static boolean isValidPassportField(String passportField) {

        String fieldKey = passportField.substring(0, passportField.indexOf(COLON_SEPARATOR)).trim();
        String fieldValue = passportField.substring(passportField.indexOf(COLON_SEPARATOR) + 1).trim();
        return validate(fieldKey, fieldValue);
    }

    private static boolean validate(String key, String value) {
        switch (key) {
            case "byr":
                return hasYearRange(value, 1920, 2002);
            case "iyr":
                return hasYearRange(value, 2010, 2020);
            case "eyr":
                return hasYearRange(value, 2020, 2030);
            case "hcl":
                return value.matches("^#[a-f0-9]{6}$");
            case "ecl":
                return value.matches("^(amb|blu|brn|gry|grn|hzl|oth)$");
            case "pid":
                return value.matches("[0-9]{9}");
            case "hgt":
                var unitValue = value.substring(0, value.length() - 2);
                var unit = value.substring(value.length() - 2);
                return switch (unit) {
                    case "cm" -> isWithinRange(unitValue, 150, 193);
                    case "in" -> isWithinRange(unitValue, 59, 76);
                    default -> false;
                };
            default:
                return false;
        }
    }

    private static boolean hasYearRange(String value, int startYear, int endYear) {
        if (!isYear(value)) return false;
        return isWithinRange(value, startYear, endYear);
    }

    private static boolean isWithinRange(String value, int start, int end) {
        return Integer.parseInt(value) > start && Integer.parseInt(value) <= end;
    }

    private static boolean isYear(String value) {
        return value != null && value.matches("[0-9]{4}");
    }
}