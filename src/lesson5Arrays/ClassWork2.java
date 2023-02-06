package lesson5Arrays;

import java.util.Random;

public class ClassWork2 {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();
        System.out.print("\n       Array: ");

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
            System.out.print(array[i] + " ");
        }
        System.out.print("\nRevers array:");
        for (int idexAray = array.length - 1; idexAray >= 0; idexAray--) {
            System.out.print(" " + array[idexAray]);
        }
    }
}