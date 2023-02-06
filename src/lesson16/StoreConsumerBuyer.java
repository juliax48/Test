package lesson16;

import com.sun.tools.javac.Main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.IntStream;

public class StoreConsumerBuyer {
    public static void main(String[] args) {
        StoreM storeM = new StoreM(0);

        Clienter clienter = new Clienter(storeM);
        Worker worker = new Worker(storeM);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(worker::putGoodToStore);
        executorService.execute(clienter::buyItemToStore);

        executorService.shutdown();
    }

    public static void printThreadName(String massage) {
        System.out.println(Thread.currentThread().getName() + massage);
    }
}

class StoreM {
    private int item;

    public StoreM(int item) {
        this.item = item;
    }

    public synchronized void putItem() {
        if (item < 3) {

            StoreConsumerBuyer.printThreadName(" Put item = " + ++item);
            notifyAll();
        } else {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void buyItem() {
        if (item > 2) {
            StoreConsumerBuyer.printThreadName(" Buy item = " + --item);
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}


class Worker {

    private final StoreM storeM;

    public Worker(StoreM storeM) {
        this.storeM = storeM;
    }


    public void putGoodToStore() {
        for (int i = 0; i < 15; i++) {
            storeM.putItem();
        }
    }
}

class Clienter {
    private final StoreM storeM;

    public Clienter(StoreM storeM) {
        this.storeM = storeM;
    }

    public void buyItemToStore() {
        for (int i = 0; i < 15; i++) {
            storeM.buyItem();
        }
    }
}