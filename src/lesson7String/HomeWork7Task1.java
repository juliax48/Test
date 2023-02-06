package lesson7String;


import java.util.Scanner;

public class HomeWork7Task1 {
    public static void main(String[] args) {
        System.out.println("Please, enter any string");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("Original string = " + str);

        if (str.startsWith("abc")) {
            str = str.replace("abc", "www");
        } else {
            str = str.concat("ttt");
        }

        System.out.println("Changed string = " + str);
    }

}
