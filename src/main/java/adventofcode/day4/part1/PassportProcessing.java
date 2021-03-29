package adventofcode.day4.part1;

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