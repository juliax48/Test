package lesson5Arrays;

import java.util.Arrays;
import java.util.OptionalInt;

public class CoutArray {
    public static void main(String[] args) {
        int[][] array = {{2, 4}, {2, 4}};

        int[] total = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            // loop for inner array
            for (int k = 0; k < array[i].length; k++) {
                // since default value of total[i] is 0, we can directly use +=
                total[i] += array[i][k];
            }
        }
// print the array
        System.out.println(Arrays.toString(total));
    }
}




//        int sum1 = 0;
//        int mul = 0;
//
//        for (int i = 0; i < array.length; i++) {
//            sum1 += array[i];
//        }
//        System.out.println("sum1 = " + sum1);
//
//        for (int i = 0; i < array.length - 1; i++) {
//            mul = array[i] * array[i + 1];
//        }
//
//        System.out.println("mul = " + mul);
//    }


