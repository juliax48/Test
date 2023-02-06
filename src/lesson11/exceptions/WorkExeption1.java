package lesson11.exceptions;

public class WorkExeption1 {
    public static void main(String[] args) {

        int a = 4;
        int b = 0;
        double result;
        try {
            result = a / b;
        }
        catch (Exception ex) {
            System.out.println("not divide 0");
        }

        //System.out.println(result);
    }
}
