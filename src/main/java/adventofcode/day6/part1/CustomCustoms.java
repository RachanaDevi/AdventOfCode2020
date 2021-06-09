package adventofcode.day6.part1;

import adventofcode.utilities.FileReader;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CustomCustoms {

    public String[] groups(String fileName, String replacement) throws IOException {
        return FileReader.contentSeparatedByABlankLine(fileName, replacement);
    }

    public int uniqueAnswerSum(String fileName) throws IOException {
        String[] groups = groups(fileName, "");
        int uniqueAnswers = 0;
        for (String groupAnswer : groups) {
            Set<String> answerSet = new HashSet<>();
            String[] answers = groupAnswer.split("");
            Collections.addAll(answerSet, answers);
            uniqueAnswers += answerSet.size();
        }
        return uniqueAnswers;
    }

    public int allAgreedAnswersFromGroups(String fileName) throws IOException {
        String[] groups = groups(fileName, " ");
        int result = 0;
        for (String groupAnswer : groups) {
            Integer groupMembers = getAgreedAnswersFromGroupMembers(groupAnswer);
                result += groupMembers;
        }
        return result;
    }

    public Integer getAgreedAnswersFromGroupMembers(String groupAnswer) {
        int finalCount = 0;
        String[] groupMembers = groupAnswer.split(" "); // a, ba, ca
        HashMap<String, Integer> groupAnswerCount = new HashMap<>();
        for (String groupMember : groupMembers) { //a
            if (groupMembers.length == 1) {
                return groupMembers[0].length();
            }
            String[] groupMemberAnswers = groupMember.split("");
            for (String groupMemberAnswer : groupMemberAnswers) { //a
                if (groupAnswerCount.containsKey(groupMemberAnswer)) {
                    int value = groupAnswerCount.get(groupMemberAnswer) + 1;
                    if (value == groupMembers.length) {
                        finalCount += 1;
                    }
                    groupAnswerCount.put(groupMemberAnswer, value);
                } else {
                    groupAnswerCount.put(groupMemberAnswer, 1);
                }

            }
        }
        return finalCount;
    }
}
