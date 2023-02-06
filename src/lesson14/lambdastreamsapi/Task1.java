package lesson14.lambdastreamsapi;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Task1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Random random = new Random();
        List<Integer> integers = IntStream.range(1, 6)
                .map(value -> random.nextInt(10))
                .boxed().toList();
        System.out.println("integers = " + integers);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<List<Integer>> callableDirectSorted = () -> integers.stream()
                .sorted(Integer::compareTo)
                .toList();

        Callable<List<Integer>> callableReverseSorted = () -> integers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        Future<List<Integer>> futureDirectSorted = executorService.submit(callableDirectSorted);
        Future<List<Integer>> futureReverseSorted = executorService.submit(callableReverseSorted);

        while (!futureDirectSorted.isDone() || !futureReverseSorted.isDone()) {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException ex) {
                ex.getMessage();
            }
            executorService.shutdown();

            List<Integer> listDirectedSorted = futureDirectSorted.get();
            List<Integer> listReverseSorted = futureReverseSorted.get();

            System.out.println("listDirectedSorted = " + listDirectedSorted);
            System.out.println("listReverseSorted = " + listReverseSorted);


        }

    }
}


//        Comparator<String> comparatorByNumber = new Comparator<String>() {
//            @Override
//            public int compare(String i1, String i2) {
//                return i1.substring(1, 2).compareTo(i2.substring(1, 2));
//            }
//        };
//
//        myList = myList.stream()
//                .sorted(comparatorByNumber).collect(Collectors.toList());
//
//        Comparator<String> comparatorByLetter = new Comparator<String>() {
//            @Override
//            public int compare(String i1, String i2) {
//                return i2.substring(0, 1).compareTo(i1.substring(0, 1));
//            }
//        };
//
//        myList = myList.stream().sorted(comparatorByLetter).collect(Collectors.toList());

//        List<Integer> collections = new ArrayList<>(5);
//        int maxIndex = 5;
//        Random random = new Random();
//
//        for (int i = 0; i<maxIndex; i++){
//            int value = 0;
//            value = random.nextInt(1,10);
//            collections.add(value);
//        }
//        System.out.println(collections);