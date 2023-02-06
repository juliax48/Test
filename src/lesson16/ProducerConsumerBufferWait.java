package lesson16;

import java.util.concurrent.TimeUnit;

public class ProducerConsumerBufferWait {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        ProducerX producer = new ProducerX(buffer);
        ConsumerX consumer = new ConsumerX(buffer);

        Thread threadConsumer = new Thread(producer);
        Thread threadProducer = new Thread(consumer);
        threadConsumer.start();
        threadProducer.start();

//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        executorService.execute(producer);
//        executorService.execute(consumer);
//        executorService.shutdown();
    }
    public static void printThreadNameX(String massage) {
        System.out.println(Thread.currentThread().getName() + " " + massage);
    }
}

class Buffer {
    private int messageCount = 0;
    public synchronized void get() {
        while (messageCount < 1) { // пока меньше одного мы ожидаем(засыпает)
            try {
                ProducerConsumerBufferWait.printThreadNameX("Wait get");
                wait(); // ожидаем монитор объекта разблокирубет
            } catch (InterruptedException e) { /* ... */ }
        }
        messageCount--;
        ProducerConsumerBufferWait.printThreadNameX("Reduce" + messageCount);
        notifyAll();
    }

    public synchronized void put() {
        while (messageCount >= 4) { // работем пока будет 4
            try {
                ProducerConsumerBufferWait.printThreadNameX("Wait put");
                wait(); // засыпает
            } catch (InterruptedException e) { /* ... */ }
        }
        messageCount++;

        ProducerConsumerBufferWait.printThreadNameX("Increase" + messageCount);
        notifyAll();

        try {
            TimeUnit.MICROSECONDS.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

class ConsumerX implements Runnable { // пользователь
    Buffer buffer;
    ConsumerX(Buffer store) {
        this.buffer = store;
    }
    public void run() {
        for (int i = 1; i < 10; i++) {
            ProducerConsumerBufferWait.printThreadNameX("count " + i);
            buffer.get();
        }
    }
}

class ProducerX implements Runnable {
    Buffer store;
    ProducerX(Buffer buffer) {
        this.store = buffer;
    }
    public void run() { // заходим в метод Run, вызывем метод Put, переходим
        for (int i = 1; i < 10; i++) {
            ProducerConsumerBufferWait.printThreadNameX("count " + i);
            store.put();
        }
    }
}