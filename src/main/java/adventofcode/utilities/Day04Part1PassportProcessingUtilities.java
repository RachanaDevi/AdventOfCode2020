package adventofcode.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day04Part1PassportProcessingUtilities {

    public static String getPassports(String filePath) throws IOException {
        var fileReader = Files.readString(Paths.get(filePath));
        return fileReader.replace("\n", " ");
    }

    static String[] removeNewLines(String[] passports) {
        String[] newPassports = new String[passports.length];
        int i = 0;
        for (String passport : passports) {
            newPassports[i++] = passport.replace("\n", "");
        }
        return newPassports;
    }

    public static String[] splitByTwoNewlines(String fileReader) {
        return fileReader.split("\n\n");
    }
}