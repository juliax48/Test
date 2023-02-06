package lesson3;

import java.util.Scanner;

public class HomeWork3Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter serial number of the finger");
        int digit = scanner.nextInt();

        switch (digit) {
            case 1: {
                System.out.println("Entered number the finger is name thumb");
                break;
            }
            case 2: {
                System.out.println("Entered number the finger is forefinger");
            }
            break;
            case 3: {
                System.out.println("Entered number the finger is middle finger");
            }
            break;
            case 4: {
                System.out.println("Entered number the finger is ring finger");
            }
            break;
            case 5: {
                System.out.println("serial number of the finger is little finger");
            }
            break;
            default:
                System.out.println("You entered wrong digit. Please enter digit from 1 to 5");
        }
    }

}
