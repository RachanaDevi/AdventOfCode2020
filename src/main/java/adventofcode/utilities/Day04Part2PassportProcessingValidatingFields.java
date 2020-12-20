package adventofcode.utilities;

public class Day04Part2PassportProcessingValidatingFields {

    private static final String COLON_SEPARATOR = ":";

    public static boolean validateField(String passportField) {

        String fieldKey = passportField.substring(0, passportField.indexOf(COLON_SEPARATOR));
        String fieldValue = passportField.substring(passportField.indexOf(COLON_SEPARATOR) + 1);
        return validate(fieldKey, fieldValue);
    }

    private static boolean validate(String key, String value) {
        switch (key) {
            case "byr":
                if (value != null && value.matches("[0-9]{4}"))
                    return Integer.parseInt(value) >= 1920 && Integer.parseInt(value) <= 2002;
                break;
        }
        return false;
    }
}