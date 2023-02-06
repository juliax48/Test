package Thread_lesson13.tread;

public class Work2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start");
        Thread thread1 = new Thread(new Task1());
        Thread thread2 = new Thread(new Task2());
        thread1.start();
        thread2.start();
        System.out.println("main finish");

    }
}

class Task1 implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <=5; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " -  " + i);
        }
    }
}
class Task2 implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <=5; i++){
            System.out.println(Thread.currentThread().getName() + " -  " + i);
        }
    }
}
