package adventofcode;

public class Day04Part1PassportProcessing {

    public static Integer validPassports(String[] passports) {
        var count = 0;
        for (String passport : passports) {
            if (areValidFieldsPresent(passport)) {
                count++;
            }
        }
        return count;
    }


    static boolean areValidFieldsPresent(String passport) {
        String[] passportRequiredFields = {"ecl",
                "pid",
                "eyr",
                "hcl",
                "byr",
                "iyr",
                "hgt"};
        for (String passportRequiredField : passportRequiredFields) {
            if (!passport.matches(".*(\s|^)" + passportRequiredField + "(\s|$).*")) {
                return false;
            }
        }
        return true;
    }
}