package lesson16;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class ExchangeApplication {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        Client client = new Client(exchanger);
        Seller seller = new Seller(exchanger);

        new Thread(client::ask, "Client").start();

        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException ex) {
            printErr(ex.getMessage());
        }

        new Thread(seller::answer, "Seller").start();
    }

    public static void print(Object message) {
        System.out.println(Thread.currentThread().getName() + ": " + message);
    }

    public static void printErr(Object message) {
        System.err.println(Thread.currentThread().getName() + ": " + message);
    }

}

class Seller {

    private final Exchanger<String> exchanger; // создаем переменную которой будем обмениваться

    Seller(final Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    public void answer() {
        try {
            ExchangeApplication.print("Start of the answer to the question.");

            String question = exchanger.exchange("Question is accepted");
            ExchangeApplication.print("Question is [" + question + "]");

            ExchangeApplication.print("Sending the answer [It is easy]");
            exchanger.exchange("It is easy");

            ExchangeApplication.print("End of the answer to the question.");
        } catch (InterruptedException e) {
            ExchangeApplication.printErr("Failed to interact with client. " + e.getMessage());
        }
    }

}

class Client {

    private final Exchanger<String> exchanger;

    Client(final Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    public void ask() {
        try {
            ExchangeApplication.print("Start asking to the question.");

            ExchangeApplication.print("Question is [How can I buy a book?]");
            String questionStatus = exchanger.exchange("How can I buy a book?");
            ExchangeApplication.print("Question status is  [" + questionStatus + "]");

            String answer = exchanger.exchange(null);
            ExchangeApplication.print("Answer is [" + answer + "]");

            ExchangeApplication.print("End of the asking question.");
        } catch (InterruptedException e) {
            ExchangeApplication.printErr("Failed to interact with client. " + e.getMessage());
        }
    }

}


