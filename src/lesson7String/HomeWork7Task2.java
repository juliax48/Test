package lesson7String;

import java.util.Scanner;

public class HomeWork7Task2 {
    public static void main(String[] args) {
        System.out.println("Please, enter an unnormalized string that contains extra spaces");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("Unnormalized string = " + str);

        str = str.trim();
        str = str.replaceAll("[\\s]{2,}", " ");
        System.out.println("Normalized string = " + str);
    }
}





