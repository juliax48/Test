package lesson16;

public class DirectorDoctor {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Doctor());
        Thread thread2 = new Thread(new Director());

        thread1.start(); // не видит другого потока, закешировано people 0
        thread2.start(); // не видит другого потока, закешировано people 0

    }
}


class Reception {
    public volatile static int people = 0; // потоки ображаются к это переменной

}

class Doctor implements Runnable {


    @Override
    public void run() {
        for(int count = 0; count <=10; count++){
            System.out.println("people " + Reception.people++);
        }
        System.out.println("Doctor finished work");

    }
}

class Director implements Runnable {

    @Override
    public void run() {
        while (true) {
            if (Reception.people > 1) {
                break;
            }
        }
        System.out.println("director finished work");
    }
}