package lesson16;

import java.util.stream.IntStream;

public class NotifyWaitApplication {
    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

        Thread consumer1Thread = new Thread(producer, "producer");
        Thread consumer2Thread = new Thread(consumer, "consumer");

        consumer1Thread.start();
        consumer2Thread.start();

    }

    public static void print(Object message) {
        System.out.println(Thread.currentThread().getName() + ": " + message);
    }

    public static void printErr(Object message) {
        System.err.println(Thread.currentThread().getName() + ": " + message);
    }

}

class Store {

    private int counter;

    public synchronized void get() {
        while (counter < 1) {
            try {
                NotifyWaitApplication.print("Wait");
                wait();
            } catch (InterruptedException e) {
                NotifyWaitApplication.printErr(e.getMessage());
            }
        }

        counter--;
        NotifyWaitApplication.print(counter);
        notifyAll();
    }

    public synchronized void put() {
        while (counter > 3) {
            try {
                NotifyWaitApplication.print("Wait");
                wait();
            } catch (InterruptedException e) {
                NotifyWaitApplication.printErr(e.getMessage());
            }
        }

        counter++;
        NotifyWaitApplication.print(counter);
        notifyAll();
    }

}
class Producer implements Runnable {

    private final Store store;

    Producer(final Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        IntStream.range(1, 11)
                .peek(i -> NotifyWaitApplication.print("counter "+ i))
                .forEach(i -> store.put());
    }

}

class Consumer implements Runnable {

    private final Store store;

    Consumer(final Store store) {
        this.store = store;
    }


    @Override
    public void run() {
        IntStream.range(1, 6)
                .peek(i -> NotifyWaitApplication.print("counter "+ i))
                .forEach(i -> store.get());
    }

}
