package adventofcode.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day04Part1PassportProcessingUtilities {

    public static String getPassports(String filePath) throws IOException {
        var fileReader = Files.readString(Paths.get(filePath));
        return fileReader.replace("\n", " ");
    }
}