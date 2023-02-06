package lesson15.poll;

import java.util.*;
import java.util.stream.Stream;

public class Threads {
    public static void main(String[] args) {
        List<Integer> maxMin = createMatrix(10);

        List<Integer> list = Arrays.asList(4,5,6,7,8,9,3);

        Thread threadMax = new Thread(new MaxValue(list));
        threadMax.start();

        Thread threadMin = new Thread(new MinValue(list));
        threadMin.start();

        while (threadMax.isAlive() && threadMin.isAlive()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
    }
    public static List<Integer> createMatrix(int arraySize) {
        List<Integer> createMatrixInteger = new ArrayList<>();

        Random random = new Random();
        List<Integer> matrix = new ArrayList<>(arraySize);

        for (int index = 0; index < arraySize; index++) {
            matrix.add(random.nextInt(10) + 1);
        }
        return createMatrixInteger;
    }

}


class MinValue implements Runnable {
    private List<Integer> integerList;
    private int result;

    public MinValue(List<Integer> integerList) {
        this.integerList = integerList;

    }

    public int getResult() {
        return result;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        result = integerList.stream()
                .min(Integer::compareTo)
                .orElse(0);
        System.out.println(result);
    }
}

class MaxValue implements Runnable {
    private List<Integer> integerList;
    private int result;

    public MaxValue(List<Integer> integerList) {
        this.integerList = integerList;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        result = integerList.stream()
                .max(Integer::compareTo)
                .orElse(0);
        System.out.println(result);
    }

    public int getResult() {
        return result;
    }
}




