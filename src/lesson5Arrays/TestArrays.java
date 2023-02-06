package lesson5Arrays;

public class TestArrays {
    public static void main(String[] args) {
        int[] myArray = {4, 2, 5, 12};
        int max = myArray[0];

        for (int i : myArray) {
            if (i > max) {
                max = i;
            }
        }
        System.out.println(max);
    }
}

