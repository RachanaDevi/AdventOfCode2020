package adventofcode;

public class Day04Part1PassportProcessing {

    public static boolean areValidFieldsPresent(String passport) {
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