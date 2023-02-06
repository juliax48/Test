package newtasks;

public class Classs {
    public static void main(String[] args) {

    }
}

class Human {

}

class Man extends Human {
    String name;

    public Man() {
        super();
        this.name = "Anna";
    }
}

class C {
    int x;

    public C(int x) {
        this.x = x;
    }
}

class D extends C {
    String s;

    public D(int x, String s) {
        super(x);
        this.s = s;
    }

}

interface Test {
    int x = 5;

    void foo();
}

interface Currency {
    double getCurrency();
}

interface Time {
    double getTime();
}

interface TimeCurrency extends Time, Currency {
}



