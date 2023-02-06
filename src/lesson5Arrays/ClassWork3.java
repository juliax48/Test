package lesson5Arrays;

import java.util.Random;

public class ClassWork3 {
    public static void main(String[] args) {
        int[] array = new int[4];
        Random random = new Random();

        for (int firstindex = 0; firstindex < array.length; firstindex++) {
            array[firstindex] = random.nextInt(9) + 1;
        }
        for (int firstindex = 0; firstindex < array.length; firstindex++) {
            for (int secondIndex = 0; secondIndex < args.length; secondIndex++) {
                if (firstindex != secondIndex) {
                    System.out.println(array[firstindex]);
                }
            }
            System.out.println();
        }
    }
}
