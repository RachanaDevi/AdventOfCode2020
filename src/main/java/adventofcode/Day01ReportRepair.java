package adventofcode;

import java.util.List;

public class Day01ReportRepair {

    public static Integer findTwoNumbersProductWhoseSumIs2020(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i) + numbers.get(j) == 2020) {
                    System.out.println("[" + numbers.get(i) + "," + numbers.get(j) + "]");
                    return numbers.get(i) * numbers.get(j);
                }
            }
        }
        return null;
    }


    public static Integer findThreeNumbersProductWhoseSumIs2020(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                for (int k = j + 1; k < numbers.size(); k++) {
                    if (numbers.get(i) + numbers.get(j) + numbers.get(k) == 2020) {
                        System.out.println("[" + numbers.get(i) + "," + numbers.get(j) + "," + numbers.get(k) + "]");
                        return numbers.get(i) * numbers.get(j) * numbers.get(k);
                    }
                }
            }
        }
        return null;
    }
}
