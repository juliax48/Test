package Thread_lesson13.tread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class HomeWork13Task2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(100);

        Generator generator = new Generator(list);
        generator.start();
    }

}

class Generator extends Thread {
    List<Integer> list;

    public Generator(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int index = 0; index < 100; index++) {
            int number = random.nextInt();
            list.add(number);
            System.out.println(number);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}