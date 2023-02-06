package lesson6omeasrs;

public class HomeWork6Task2 {
    public static void main(String[] args) {
        Phone phone1 = new Phone(530603450, 5, 0.4);
        phone1.display();
        phone1.reseiveCall("Tom");
        phone1.getNumber();
        phone1.receiveCall("Tom", 544344543);
        System.out.println();

        Phone phone2 = new Phone(456340540, 3, 0.5);
        phone2.display();
        phone2.reseiveCall("Sem");
        phone2.getNumber();
        System.out.println();

        Phone phone3 = new Phone(345876780, 1, 0.45);
        phone3.display();
        phone3.reseiveCall("Bob");
        phone3.getNumber();
        System.out.println();

        Phone.sendMessage(6434345, 6435555, 6404040);
    }
}

class Phone {
    int number;
    int model;
    double weight;

    public Phone(int number, int model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public void display() {
        System.out.println("Number is " + number + " model is " + model + " weight is " + weight);
    }

    public void reseiveCall(String name) {
        System.out.println("Calling " + name);
    }

    public void getNumber() {
        System.out.println("Number is " + number);
    }

    public void receiveCall(String name, int number) {
        System.out.println("Calling " + name + " namber " + number);
    }

    public static void sendMessage(int... numbers) {
        for (int x : numbers) {
            System.out.println("Numbers to sent massege: " + x);
        }
    }
}
