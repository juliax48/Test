package Thread_lesson13.tread;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Thread2 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("size");
        List<Integer> list = new ArrayList<>();
        int sizeArray = scanner.nextInt();
        System.out.println("elements");

        for(int i = 0; i<sizeArray; i++){
            list.add(scanner.nextInt());
                    }
        System.out.println("List: ");
        for(Integer ls : list){
            System.out.print(ls + " ");
        }

        System.out.println(Thread.currentThread().getName() + "main start");
        Thread thread = new Thread(new NewThread());
        Thread thread1 = new Thread(new NewThread2());

        thread1.start();
        thread.start();

        System.out.println(Thread.currentThread().getName() + "main finish");
    }
}

class NewThread extends Thread{
    @Override
    public void run() {
        for (int i=0; i<10; i++){
            System.out.println("i " + i);
        }
    }
}
class NewThread2 extends Thread {

    @Override
    public void run() {
        for (int q = 0; q < 10; q++) {
            System.out.println("q " + q);
        }
    }
}
