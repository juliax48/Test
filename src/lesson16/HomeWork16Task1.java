package lesson16;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class HomeWork16Task1 {
    public static void main(String[] args) {
        Semaphore semaphoreWriter = new Semaphore(1, true);
        Semaphore semaphoreReader = new Semaphore(99, true);

        BaseData baseData = new BaseData(semaphoreWriter, semaphoreReader);

        List<User> userList = Arrays.asList(
                new Writer("BodW", baseData),
                new Reader("YobR", baseData),
                new Writer("SonW", baseData),
                new Reader("DonR", baseData),
                new Writer("DedW", baseData),
                new Reader("SemR", baseData));

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        userList.forEach(user -> executorService.submit(user::doAction));

        executorService.shutdown();
    }

}


class BaseData {
    private final Semaphore semaphoreWriter;
    private final Semaphore semaphoreRider;

    public BaseData(Semaphore semaphoreWriter, Semaphore semaphoreRider) {
        this.semaphoreWriter = semaphoreWriter;
        this.semaphoreRider = semaphoreRider;
    }

    public void getAccess(User user) {
        try {
            SemaphoreApplication.print(user.getUserName() + " tries to get access");

            if (user instanceof Writer) {
                semaphoreRider.acquire(99);
                semaphoreWriter.acquire(); // доступ забираем
                SemaphoreApplication.print(user.getUserName() + " got access");
                TimeUnit.MILLISECONDS.sleep(4000);

                System.out.println(user.getUserName() + " tries to release");
                semaphoreWriter.release();
                semaphoreRider.release(99);

            }
            if (user instanceof Reader) {
                semaphoreRider.acquire();
                SemaphoreApplication.print(user.getUserName() + " got access");
                TimeUnit.MILLISECONDS.sleep(4000);

                System.out.println(user.getUserName() + " tries to release");

                semaphoreRider.release();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}

class User {
    private final String userName;
    private final BaseData baseData;

    public User(String userName, BaseData baseData) {
        this.userName = userName;
        this.baseData = baseData;
    }

    public String getUserName() {
        return userName;
    }

    public void doAction() {
        baseData.getAccess(this);
    }
}

class Writer extends User {
    public Writer(String writerName, BaseData baseData) {
        super(writerName, baseData);
    }

    @Override
    public void doAction() {
        System.out.println(this.getUserName() + " tries to start writing");
        super.doAction();

    }
}

class Reader extends User {

    public Reader(String readerName, BaseData baseData) {
        super(readerName, baseData);
    }

    @Override
    public void doAction() {
        System.out.println(this.getUserName() + " tries to start reading");
        super.doAction();
    }
}


