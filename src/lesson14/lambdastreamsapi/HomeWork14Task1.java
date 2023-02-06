package lesson14.lambdastreamsapi;

import java.util.*;
import java.util.stream.Stream;

public class HomeWork14Task1 {
    public static void main(String[] args) {
        Random random = new Random();

        Collection<Integer> myCollection = new ArrayList<>(10);
        for (int index = 0; index < 10; index++) {
            myCollection.add(random.nextInt(15) + 1);
        }

        Stream.of(myCollection)
                .forEach(System.out::println);

        int minNumber = myCollection.stream()
                .min(Integer::compareTo).get();
        System.out.println("minNumber = " + minNumber);

        int maxNumber = myCollection.stream()
                .max(Integer::compareTo).get();
        System.out.println("maxNumber = " + maxNumber);

        OptionalDouble averageNumber = myCollection.stream()
                .mapToInt((x) -> {
                    return Integer.parseInt(String.valueOf(x));
                }).average();
        System.out.println("averageNumber = " + averageNumber);

        int multiplicationNumbers = myCollection.stream()
                .reduce(1, (accumulator, x) -> accumulator * x);
        System.out.println("multiplicationNumbers = " + multiplicationNumbers);

        Integer sumNumbers = myCollection.stream()
                .reduce(Integer::sum).orElse(0);
        System.out.println("sumNumbers = " + sumNumbers);

        Integer sumOddNumber = myCollection.stream()
                .filter(x -> x % 2 != 0)
                .reduce((x1, x2) -> x1 + x2).orElse(0);
        System.out.println("sumOddNumber = " + sumOddNumber);

        Integer sumDigit = myCollection.stream()
                .reduce(0, (count, x) ->
                        count + (x / 10) + (x % 10));
        System.out.println("sumDigit = " + sumDigit);
    }

}
