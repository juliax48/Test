package lesson15.poll;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Work1 {
    public static void main(String[] args) {
        Runnable first = new MaxValueRunable(Arrays.asList(1,2), "1-2");
        Runnable second = new MaxValueRunable(Arrays.asList(3,4), "1-2");
        Runnable third = new MaxValueRunable(Arrays.asList(10,22), "10-22");
        Runnable forth = new MaxValueRunable(Arrays.asList(20,44), "30-44");


        ExecutorService executorService = new ThreadPoolExecutor(1,2,
                100, TimeUnit.MICROSECONDS, new ArrayBlockingQueue<>(1));

        Future <?> future1 = executorService.submit(first);
        Future <?> future2 = executorService.submit(second);
        Future <?> future3 =executorService.submit(third);
        Future <?> future4 = executorService.submit(forth);
    }
}

class MaxValueRunable implements Runnable{
    private final List<Integer> integerList;
    private int result;

    public MaxValueRunable(List<Integer> integerList, String s) {
        this.integerList = integerList;
    }

    public int getResult() {
        return result;
    }

    @Override
    public void run() {
        result = integerList.stream()
                .max(Integer::compareTo)
                .orElse(Integer.MIN_VALUE);
    }
}

class ApplicationThread implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Runneble cannot be precesed" + this);
    }
}