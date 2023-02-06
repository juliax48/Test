package Thread_lesson13.tread;

import java.util.*;

public class HomeWork13Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter array size");
        int arraySize = input.nextInt();

        List<Integer> array = new ArrayList<>(arraySize);

        System.out.println("Enter array elements");

        for (int index = 0; index < arraySize; index++) {
            array.add(input.nextInt());
        }

        input.close();

        System.out.println("Entered elements: ");
        System.out.println(array);

        Thread threadMaxArray = new Thread(new MaxArray(array));
        Thread threadMinArray = new Thread(new MinArray(array));

        threadMaxArray.start();
        threadMinArray.start();

        while (threadMinArray.isAlive() && threadMaxArray.isAlive()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}

class MaxArray implements Runnable {
    private List<Integer> array;

    public MaxArray(List<Integer> array) {
        this.array = array;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("Max element of array:  " + Collections.max(array));
    }
}

class MinArray implements Runnable {
    private List<Integer> array;

    public MinArray(List<Integer> array) {
        this.array = array;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("Max element of array:  " + Collections.min(array));
    }
}

