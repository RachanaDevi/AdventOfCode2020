package adventofcode.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {

    public static String[] contentSeparatedByABlankLine(String filePath, String replacement) throws IOException {
        var fileAsString = Files.readString(Paths.get(filePath));
        var contents = splitByTwoNewlines(fileAsString);
        return removeNewLines(contents, replacement);
    }

    public static String[] removeNewLines(String[] contents, String replacement) {
        String[] contentArray = new String[contents.length];
        int i = 0;
        for (String content : contents) {
            contentArray[i++] = content.replace("\n", replacement);
        }
        return contentArray;
    }

    static String[] splitByTwoNewlines(String fileAsString) {
        return fileAsString.split("\n\n");
    }
}