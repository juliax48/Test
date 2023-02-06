package lesson12.read;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadCountCharText {
    public static void main(String[] args) throws IOException {
        List<String> wodrs = Arrays.asList("Hello", "Word", "Java");


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Words.txt", StandardCharsets.UTF_8))) {
            for (String word : wodrs) {
                bufferedWriter.write(word + "\n");
            }
            bufferedWriter.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Words.txt", StandardCharsets.UTF_8))) {
            int symbol = -1;
            while ((symbol = bufferedReader.read()) != -1) {
                stringBuilder.append((char) symbol);
            }
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char symbol : stringBuilder.toString().toCharArray()) {
            int counter = 1;
            if (map.containsKey(symbol)) {
                counter = map.get(symbol) + counter;
                map.put(symbol, counter);
            } else {
                map.put(symbol, 1);
            }
        }
        System.out.println("map = " + map);
    }
}

