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

    public int uniqueAnswerSum(String fileName) throws IOException {
        String[] groups = groups(fileName);
        int uniqueAnswers = 0;
        for (String groupAnswer : groups) {
            Set<String> answerSet = new HashSet<>();
            String[] answers = groupAnswer.split("");
            Collections.addAll(answerSet, answers);
            uniqueAnswers += answerSet.size();
        }
        return uniqueAnswers;
    }
}
