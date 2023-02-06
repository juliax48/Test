package lesson5Arrays;

import java.util.Arrays;

public class HomeWork5Task2 {
    public static void main(String[] args) {
        int[] array = {3, 5, 0, 1, 1, 3, 5, 2, 2, 2, 4};
        int[] newArray = new int[0];

        System.out.print("Array: ");
        for (int indexRow = 0; indexRow < array.length; indexRow++) {
            boolean isUniq = true;
            for (int indexColumn = 0; indexColumn < newArray.length; indexColumn++) {
                if (array[indexRow] == newArray[indexColumn]) {
                    isUniq = false;
                }
            }

            if (isUniq == true) {
                newArray = Arrays.copyOf(newArray, newArray.length + 1);
                newArray[newArray.length - 1] = array[indexRow];
            }
        }

        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index] + " ");
        }

        System.out.println();
        System.out.print("New array with unique numbers: ");
        for (int numbers : newArray) {
            System.out.print(numbers + " ");
        }
    }
}
