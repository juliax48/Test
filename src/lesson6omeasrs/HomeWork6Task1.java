package lesson6omeasrs;

public class HomeWork6Task1 {
    public static void main(String[] args) {
        Fraction fraction = new Fraction(2, 1);
        fraction.displayOutput();

        double resultAddition = fraction.additionFractions(2, 1);
        System.out.println("result addition = " + resultAddition);

        double resultMultiplication = fraction.multiplicationFractions(1);
        System.out.println("result multiplication = " + resultMultiplication);

        double resultDivision = fraction.divisionFractions(1);
        System.out.println("result division = " + resultDivision);
    }

}

class Fraction {
    int numerator;
    int denominator;
    double addFractions;
    double multiFractions;
    double divisionFractions;


    public Fraction(int numerator, int denominator) {
        this.denominator = denominator;
        this.numerator = numerator;
    }

    public void displayOutput() {
        System.out.println("Fractions: " + numerator + " / " + denominator);
    }

    double additionFractions(double numerator1, double denominator1) {
        addFractions = (numerator / numerator1) + (denominator / denominator1);
        return addFractions;
    }

    double multiplicationFractions(double number) {
        multiFractions = (numerator / denominator) * number;
        return multiFractions;
    }

    double divisionFractions(double number) {
        divisionFractions = (numerator / denominator) / number;
        return divisionFractions;
    }
}






