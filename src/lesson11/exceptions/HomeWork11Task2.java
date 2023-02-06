package lesson11.exceptions;

public class HomeWork11Task2 {
    public static void main(String[] args) {
        OperationDivide operation = new OperationDivide();
        try {
            operation.divide(4, 0);
        } catch (DivideException ex) {
            System.err.println(ex.getMessage());
        }
    }
}

interface CalculationOperations {
    public double divide(int a, int b) throws DivideException;
}

class OperationDivide implements CalculationOperations {
    @Override
    public double divide(int a, int b) throws DivideException {
        if (b == 0) {
            throw new DivideException("You can not divide 0");
        }
        return a / b;
    }
}

class DivideException extends Exception {
    public DivideException(String message) {
        super(message);
    }
}

