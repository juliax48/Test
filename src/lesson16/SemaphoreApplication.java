package lesson16;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreApplication {
    public static void main(String[] args) {
        Semaphore studentSemaphore = new Semaphore(2, true);
        ExamRoom examRoom = new ExamRoom(studentSemaphore);

        List<Student> students = Arrays.asList(
                new Student("Jon", examRoom),
                new Student("Von", examRoom),
                new Student("Don", examRoom),
                new Student("Ton", examRoom),
                new Student("Zon", examRoom));

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        students.forEach(student -> {
            executorService.submit(student::passExam);
        });

        executorService.shutdown();
    }

    public static void print(Object message) {
        System.out.println(Thread.currentThread().getName() + ": " + message);
    }

    public static void printErr(Object message) {
        System.err.println(Thread.currentThread().getName() + ": " + message);
    }

}



class ExamRoom {
    private final Semaphore semaphore;

    ExamRoom(final Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void takeExam(String studentName) {
        try {
            SemaphoreApplication.print(studentName + " is tries to enter the room");
            semaphore.acquire();

            SemaphoreApplication.print(studentName + " is passing the exam");
            TimeUnit.MILLISECONDS.sleep(500);

            SemaphoreApplication.print(studentName + " passed the exam");
            semaphore.release();
        } catch (InterruptedException ex) {
            String errorMessage = String.format("Student [%s] could pass the exam. %s", studentName, ex.getMessage());
            SemaphoreApplication.printErr(errorMessage);
        }
    }

}

class Student {

    private final String studentName;
    private final ExamRoom examRoom;


    Student(final String studentName, final ExamRoom examRoom) {
        this.studentName = studentName;
        this.examRoom = examRoom;
    }

    public void passExam() {
        examRoom.takeExam(studentName);
    }
}
