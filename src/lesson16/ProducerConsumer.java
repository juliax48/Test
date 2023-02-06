package lesson16;

public class ProducerConsumer {
    public static void main(String[] args) {
        Storage storage = new Storage(5);


        Thread threadConsumer = new Thread();
        threadConsumer.run();
        Thread threadProducer = new Thread();
        threadConsumer.run();

    }
}


class Storage {
    private int item =0;

    public synchronized void get() {
        while (item < 1) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            item--;
        }
        System.out.println("consumer bouth item");
        System.out.println("on the storage is " + item);
    }




    public Storage(int item) {
        this.item = item;
    }

}


class ProducerOne implements Runnable {
    private final int item;

    public ProducerOne(int item) {
        this.item = item;
    }

    public void run() {
        for (int i = 1; i < 5; i++) {
            System.out.println("Producer sell item " + item + i);
        }
    }
}


class ConsumerOne implements Runnable {
    private final int item;

    ConsumerOne(int item) {
        this.item = item;
    }

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            System.out.println("consumer buy item " + item + i);
        }
    }
}