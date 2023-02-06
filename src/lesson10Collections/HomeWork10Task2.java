package lesson10Collections;

import java.util.HashMap;
import java.util.Map;

public class HomeWork10Task2 {
    public static void main(String[] args) {
        String str = "abcabc";

        var result = getCharsCount(str);
        System.out.println(result);
    }

    public static Map<Character, Integer> getCharsCount(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            char current = s.charAt(i);
            if (!charCountMap.containsKey(current)) {
                charCountMap.put(current, 0);
            }
            charCountMap.put(current, charCountMap.get(current) + 1);
        }
        return charCountMap;
    }

}
