package adventofcode.day4.part2;

import static adventofcode.day4.part2.utility.PassportProcessingValidatingFieldsUtility.isValidPassportField;

public class PassportProcessing {

    public static Integer validPassports(String[] passports) {
        var count = 0;
        for (String passport : passports) {
            if (hasValidPassportFields(passport)) {
                count++;
            }
        }
        return count;
    }

    static boolean hasValidPassportFields(String passport) {
        if (allFieldsArePresent(passport)) {
            var passportFields = passport.split("\s");
            for (String passportField : passportFields) {
                if (!isValidPassportField(passportField)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static boolean allFieldsArePresent(String passport) {
        String[] passportRequiredFields = {"ecl",
                "pid",
                "eyr",
                "hcl",
                "byr",
                "iyr",
                "hgt"};
        for (String passportRequiredField : passportRequiredFields) {
            if (!passport.matches(".*(\s|^)" + passportRequiredField + ":.*(\s|$).*")) {
                return false;
            }
        }
        return true;
    }
}