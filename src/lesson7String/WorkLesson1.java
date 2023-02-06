package lesson7String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkLesson1 {
    public static void main(String[] args) {
        String value = "test test test message messaging";

        Pattern pattern = Pattern.compile("e");
        Matcher matcher = pattern.matcher(value);

        int minEven = -1;
        int maxOdd = 0;

        while (matcher.find()) {
            int index = matcher.start();
            if (index % 2 == 0) {
                if (minEven == -1) {
                    minEven = index;
                }
            } else {
                maxOdd = index;
            }

        }
        System.out.println(maxOdd);
        System.out.println(minEven);
    }
}





