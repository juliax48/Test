package lesson11.exceptions;

import java.util.Random;
import java.util.Scanner;

public class HomeWork11Task1 {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int randomNumber = random.nextInt(MAX_NUMBER);

        System.out.println("Let's play a game, " + "try to guess a random number");

        while (true) {
            try {
                System.out.println("Please enter number in the range of " + MIN_NUMBER + "-" + MAX_NUMBER);
                int enteredNumber = scanner.nextInt();

                checkEnteredNumber(enteredNumber, randomNumber);

                System.out.println("Congratulations! You lucky number is " + enteredNumber);
                break;
            } catch (UserInputException ex) {
                System.out.println(ex.getMessage());
            }
        }
        scanner.close();
    }

    private static void checkEnteredNumber(int enteredNumber, int randomNumber) throws UserInputException {
        if (enteredNumber < MIN_NUMBER || enteredNumber > MAX_NUMBER) {
            throw new UserInputException("Entered number is out of range");
        }
        if (enteredNumber < randomNumber) {
            throw new UserInputException("Entered number is smaller then a random number. Please try again and never give up");
        }
        if (enteredNumber > randomNumber) {
            throw new UserInputException("Entered number is bigger then a random number. Please try again and never give up");
        }
    }

    private static class UserInputException extends Exception {
        public UserInputException(String message) {
            super(message);
        }
    }
}