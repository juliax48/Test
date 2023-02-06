package lesson4;

public class HomeWork4Task5 {
    public static void main(String[] args) {
        int counter = 0;

        for (int h = 0; h <= 23; h++) {
            int digit1 = h % 10;
            int digit2 = h / 10;

            for (int m = 0; m <= 59; m++) {
                if (m == (digit1 * 10 + digit2)) {
                    counter++;
                    System.out.println(h + " : " + m);
                }
            }
        }
        System.out.println("Per day, the clock shows a symmetrical combination counter " + counter + " times");
    }
}
