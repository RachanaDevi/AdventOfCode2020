package adventofcode.day4.part1.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PassportProcessingUtility {

    public static String[] getPassports(String filePath) throws IOException {
        var fileReader = Files.readString(Paths.get(filePath));
        var passports = splitByTwoNewlines(fileReader);
        return removeNewLines(passports);
    }

    static String[] removeNewLines(String[] passports) {
        String[] newPassports = new String[passports.length];
        int i = 0;
        for (String passport : passports) {
            newPassports[i++] = passport.replace("\n", " ");
        }
        return newPassports;
    }

    static String[] splitByTwoNewlines(String fileReader) {
        return fileReader.split("\n\n");
    }
}