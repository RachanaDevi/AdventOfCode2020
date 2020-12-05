package adventofcode;

import java.util.ArrayList;

public class Day01ReportRepair {

    public static Integer findTwoNumbersProductWhoseSumIs2020(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i) + numbers.get(j) == 2020) {
                    return numbers.get(i) * numbers.get(j);
                }
            }
        }
        return null;
    }
}
