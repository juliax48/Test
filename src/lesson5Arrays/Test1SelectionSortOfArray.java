package lesson5Arrays;

import java.util.Random;
import java.util.Scanner;

public class Test1SelectionSortOfArray {
    public static void main(String[] args) {
        System.out.println("Enter size of array");

        Scanner scanner = new Scanner(System.in);
        int sizeOfArray = scanner.nextInt();

        int[] array = new int[sizeOfArray];

        System.out.print("First array: ");

        Random random = new Random(10);
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }

        System.out.println("SortArray: ");
        for (int i = 0; i < array.length; i++) {
            int pos = i;
            int min = array[i];
            for (int j = 0; j < array.length; j++) {
                if (array[i] < min) {
                    pos = j;    // pos - индекс наименьшего элемента
                    min = array[j];
                }
            }
            array[pos] = array[i];
            array[i] = min;
        }
        for (int x : array) {
            System.out.print(x + " ");
        }
    }
}
