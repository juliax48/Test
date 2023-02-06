package lesson.all;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {
    public static void main(String[] args) throws IOException {
        List<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("People");

        try (FileWriter writer = new FileWriter("out.txt", StandardCharsets.UTF_8)) {
            for (String el : words) {
                writer.append(el + "\n");
            }
            writer.flush();
        }
        StringBuilder builder = new StringBuilder();

        try (FileReader reader = new FileReader("out.txt", StandardCharsets.UTF_8)) {
            int symbol = -1;
            while ((symbol = reader.read()) != -1) {
                builder.append((char) symbol);
            }
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char symbol : builder.toString().toCharArray()) {
            int counter = 1;
            if (map.containsKey(symbol)) {
                counter = map.get(symbol) + counter;
            }
            map.put(symbol, counter);
        }
        System.out.println("map = " + map);
    }
}
