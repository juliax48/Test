package lesson5Arrays;

import java.util.Random;

public class HomeWork5Task1 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];

        System.out.print("Random array: ");
        for (int item = 0; item < array.length; item++) {
            array[item] = random.nextInt(10);
        }
        for (int item2 = 0; item2 < array.length; item2++) {
            System.out.print(array[item2] + " ");
        }

        System.out.println();
        int maxNum = array[0];
        int maxOddNum = array[0];
        int maxEvenNum = array[0];

        for (int index = 0; index < array.length; index++) {
            if (array[index] > maxNum) {
                maxNum = array[index];
            }
            else if (array[index] % 2 != 0 && array[index] > maxOddNum) {
                maxOddNum = array[index];
            }
            else if (array[index] % 2 == 0 && array[index] > maxEvenNum) {
                maxEvenNum = array[index];
            }
        }
        System.out.println("Max number of array: " + maxNum);
        System.out.println("Max odd number of array: " + maxOddNum);
        System.out.println("Max even number of array: " + maxEvenNum);
    }

}


