package lesson.all;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class IntengerThead {
    public static void main(String[] args) {
        List<Integer> integers = getIntegers();
        List<String> string = convectToString(integers);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<Integer> sum = () -> string.stream()
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);

        Callable<Integer> multy = () -> string.stream()
                .map(Integer::parseInt)
                .reduce(1,(x,y) -> x*y);



        Future<Integer> sumResult = executorService.submit(sum);
        Future<Integer> multyResult = executorService.submit(multy);

        while (!sumResult.isDone() || !multyResult.isDone()){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }



    }

    private static List<String> convectToString (List<Integer> integers){
        return integers.stream()
                .limit(integers.size()-1)
                .skip(1)
                .map(String::valueOf)
                .peek(System.out::println)
                .toList();

    }

    private static List<Integer> getIntegers() {
        try (Scanner scanner = new Scanner(System.in)) { // не закрывается сканер!

            List<java.lang.Integer> integer = new ArrayList<>(5);
            System.out.println("Enter 5 numbers");
            for (int index = 0; index < 5; index++) {
                integer.add(scanner.nextInt());
            }
            System.out.println("integer = " + integer);
            return integer;
        }

    }
}

