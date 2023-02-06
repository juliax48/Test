package Thread_lesson13.tread;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TaskThread {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " start");

        Thread thread1 = new Thread(new TaskOne(), "Thread 1");
        Thread thread2 = new Thread(new TaskTwo(), "Thread 2");


        RunTask runTask = new RunTask();
        Thread thread3 = new Thread(runTask,"RunTask");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            while (thread1.isAlive() || thread2.isAlive()){
                System.out.println(Thread.currentThread().getName() + " is alive" + thread1.getState());
                System.out.println(Thread.currentThread().getName() + " is alive" + thread2.getState());
                TimeUnit.SECONDS.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " finish");

        System.out.println("RunTask" + runTask.getNumber());
    }

}



class TaskOne implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " end");
    }
}

class TaskTwo implements Runnable {

    @Override
    public void run() {
        for (int counter = 1; counter < 5; counter++) {
            System.out.println(Thread.currentThread().getName() + " - " + counter);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " end");
    }
}

class RunTask implements Runnable{
    private int counter = 0;

    public int getNumber() {
        return counter;
    }

    @Override
    public void run() {
        Random random = new Random();
        int maxNumber = random.nextInt(10)+1;
        for(; counter<maxNumber; counter++){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}