package lesson14.lambdastreamsapi;

public class WorkTask1 {
    public static void main(String[] args) {

        MyInterface lambda = (a, b) -> (a + b) * 2;

        System.out.println(lambda.sum(3, 4));

        Runnable run = ()-> System.out.println("Run");
    }
}

interface MyInterface {
    int sum(int a, int b);
}

class Calculator implements MyInterface {

    @Override
    public int sum(int a, int b) {
        return a + b;
    }
}

class BankCalculator implements MyInterface {
    int kof;

    public BankCalculator(int kof) {
        this.kof = kof;
    }

    @Override
    public int sum(int a, int b) {
        return (a + b) * kof;
    }
}