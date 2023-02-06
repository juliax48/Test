package lesson5Arrays;

import java.util.Random;
import java.util.Scanner;

public class ClassWork {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumberToGess = random.nextInt(10);

        Scanner scanner = new Scanner(System.in);

        int[] usersNumberAnswers = new int[3];

        System.out.println("Please, enter number between 0 to ten? you have only 3 attemps");
        int answerAttemp = 1;
        for (; answerAttemp <= 3; answerAttemp++) {
            System.out.println("Attemp" + answerAttemp + " enter number");
            int enteredNumber = random.nextInt();

            int indexAnswer = answerAttemp - 1;
            usersNumberAnswers[answerAttemp - 1] = enteredNumber;

            if (enteredNumber == randomNumberToGess) {
                System.out.println("The number is correct");
                break;
            } else {
                System.out.println("Entered number is not correct, plese try again");
            }
        }

        System.out.println("Random number is " + randomNumberToGess);
        System.out.print("Entered numbers:");
        for (int answerIndex = 0; answerIndex < 3 && answerIndex <= (answerAttemp - 1); answerIndex++) {
            System.out.print(" " + usersNumberAnswers[answerIndex]);
        }
    }
}