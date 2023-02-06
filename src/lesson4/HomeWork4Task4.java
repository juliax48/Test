package lesson4;

public class HomeWork4Task4 { // 43840
    public static void main(String[] args) {
        int counterNumbers = 0;

        for (int i = 1; i < 99_999; i++) {
            for (int j = i; j != 0; j /= 10) {
                if (j % 10 == 4 || j % 100 == 13) {
                    counterNumbers++;
                    break;
                }
            }
        }
        System.out.println("Unlucky number 4 and 13 you need exclude from \n " +
                "100_000 number of military equipment " + counterNumbers + " times");
    }
}
