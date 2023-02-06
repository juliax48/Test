package lesson.all;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MassiveStraemInteger {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Random random = new Random();
        List<Integer> mylist = IntStream.range(1, 6)
                .map(value -> random.nextInt(10))
                .boxed().toList();
        System.out.println("mylist = " + mylist);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<List<Integer>> callableDirectSorted = () -> mylist.stream()
                .sorted(Integer::compareTo)
                .toList();

        Callable<List<Integer>> callableReverseSorted = () -> mylist.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        // передаем на исполнение

        Future<List<Integer>> futureDirectSorted = executorService.submit(callableDirectSorted);
        Future<List<Integer>> futureReverseSorted = executorService.submit(callableReverseSorted);

        while (!futureDirectSorted.isDone() | !futureReverseSorted.isDone()) {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            executorService.shutdown();
        }
        executorService.shutdown();

        List<Integer> listDirectSorted = futureDirectSorted.get();
        System.out.println("listDirectSorted = " + listDirectSorted);

        List<Integer> listReverseSorted = futureReverseSorted.get();
        System.out.println("listReverseSorted = " + listReverseSorted);


//        List<Integer> directSortMyList = mylist.stream()
//                .sorted(Integer::compareTo)
//                .toList();
//        System.out.println("sortMyList");
//        directSortMyList.forEach(System.out::println);
//
//        List<Integer> sortMyListRevers = mylist.stream()
//                .sorted(Comparator.reverseOrder())
//                .toList();
//        System.out.println("sortMyListRevers");
//        sortMyListRevers.forEach(System.out::println);
//
//        List<Integer> multiplyList = IntStream.range(0,5)
//                .mapToObj(index -> directSortMyList.get(index) * sortMyListRevers.get(index))
//                .toList();
//        System.out.println("multiplyList");
//        multiplyList.forEach(System.out::println);
    }

}


