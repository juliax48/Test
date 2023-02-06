package lesson14.lambdastreamsapi;

import java.util.*;
import java.util.stream.Collectors;

public class HomeWork14Task2 {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("a1", "a2", "a3", "b1", "b3", "c2", "c1", "c5");

        myList = myList.stream()
                .filter(s -> !s.contains("3")).collect(Collectors.toList());

        myList.sort(Comparator.comparing(i -> i.substring(1, 2)));

        myList.sort((String i1, String i2) -> i2.substring(0, 1).compareTo(i1.substring(0, 1)));

        myList = myList.stream()
                .skip(1).collect(Collectors.toList());

        myList = myList.stream()
                .limit(myList.size() - 1).collect(Collectors.toList());

        myList = myList.stream()
                .map(String::toUpperCase).collect(Collectors.toList());
        myList.forEach(System.out::println);

        long count = myList.stream().count();
        System.out.println("Elements remaining in list: " + count);
    }

}

