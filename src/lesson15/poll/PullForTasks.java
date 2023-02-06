package lesson15.poll;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.concurrent.*;

public class PullForTasks {
    public static void main(String[] args) {
        List<Integer> integerList = createMatrix(0, 10);
        System.out.println(integerList);
        
        ExecutorService executorService = new ThreadPoolExecutor(
                1,
                2,
                100, TimeUnit.MICROSECONDS,
                new ArrayBlockingQueue<>(2),
                (run, executor) -> System.out.println("element not found" + run));

        
        Callable maxValueCallable = ()-> integerList.stream()
                .max(Integer::compareTo)
                .orElse(0);
        Callable minValueCallable = ()-> integerList.stream()
                .min(Integer::compareTo)
                .orElse(0);

        Callable averageValueCallable = ()-> integerList.stream()
                .mapToInt((x) -> {
                    return Integer.parseInt(String.valueOf(x));
                }).average();
        Callable totalElementCallable = ()-> integerList.stream()
                .limit(integerList.size())
                .toList();

        Future<Integer> maxValueFuture = executorService.submit(maxValueCallable);
        Future<Integer> minValueFuture = executorService.submit(minValueCallable);
        Future<?> averageValueFuture = executorService.submit(averageValueCallable);
        Future<Integer> totalElementFuture = executorService.submit(totalElementCallable);

        while (!maxValueFuture.isDone() || !minValueFuture.isDone()) {

            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Integer resultMax = maxValueFuture.get();
            System.out.println("resultMax = " + resultMax);
            Integer resultMin = minValueFuture.get();
            System.out.println("resultMin = " + resultMin);
            //double average = (double) averageValueFuture.get();
            //System.out.println("average = " + average);

        } catch (Exception e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    public static List<Integer> createMatrix(int min, int max) {
        Random random = new Random();
        List<Integer> matrix = new ArrayList<>(max);
        for (int index = 0; index < max; index++) {
            matrix.add(random.nextInt(10) + 1);
        }
        return matrix;
    }

}

class MaxInteger implements Callable {
    private List<Integer> list = new ArrayList<>(10);

    public MaxInteger(List<Integer> list) {
        this.list = list;
    }

    @Override
    public Integer call() throws Exception {
        return list.stream()
                .max(Integer::compareTo)
                .orElse(0);
    }
}




