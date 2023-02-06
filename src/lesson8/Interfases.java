package lesson8;

public class Interfases {
    public static void main(String[] args) {
        Inform one = new Animal(4);
        Inform two = new Piople("Bob");
        one.showInfo();
        two.showInfo();
        outPutInfo(one);
        outPutInfo(two);


    }
    public static void outPutInfo (Inform info){
    info.showInfo();
    }
}

interface Run {
    public void goRun();
}
interface Inform {
    public void showInfo();
}

class Animal implements Inform, Run {
    private int id;

    public Animal(int id) {
        this.id = id;
    }

    @Override
    public void showInfo() {
        System.out.println("My Id" + id);
    }

    @Override
    public void goRun() {
        System.out.println(id + " is runing");
    }
}

class Piople implements Inform, Run {
    String name;

    public Piople(String name) {
        this.name = name;
    }

    public void dispName() {
        System.out.println("mY name is " + name);
    }

    @Override
    public void showInfo() {
        System.out.println("My name" + name);

    }

    @Override
    public void goRun() {
        System.out.println(name + " is runing");
    }
}