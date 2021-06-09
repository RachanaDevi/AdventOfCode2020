package adventofcode.day6.part1;

import adventofcode.utilities.FileReader;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CustomCustoms {

    public String[] groups(String fileName) throws IOException {
        return FileReader.contentSeparatedByABlankLine(fileName, "");
    }

    public int getUniqueAnswers(String groupAnswer) {
        String[] answers = groupAnswer.split("");
        Set<String> answerSet = new HashSet<>();
        Collections.addAll(answerSet, answers);
        return answerSet.size();
    }
}
