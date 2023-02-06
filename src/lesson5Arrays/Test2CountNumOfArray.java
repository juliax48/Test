package lesson5Arrays;

import java.util.Scanner;

public class Test2CountNumOfArray {
    public static void main(String[] args) {
        String[] array = {"Каждый ", " dsd"};
        int resultOfWords = 0;

        for (int i = 0; i < array.length; i++) {
            if (i < array.length) {
                resultOfWords++;
            }
        }
        System.out.println(resultOfWords);

        System.out.println("Enter sentens");
        Scanner scanner = new Scanner(System.in);
        String inputWords = scanner.nextLine();
        int count = 0;

        if (inputWords.length() != 0) {
            count++;
            for (int i = 0; i < inputWords.length(); i++) {
                if (inputWords.charAt(i) == ' ') {
                    count++;
                }
            }
        }
        System.out.println("You entered " + count + " words");
    }
}
