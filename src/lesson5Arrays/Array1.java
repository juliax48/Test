package lesson5Arrays;

public class Array1 {
    public static void main(String[] args) {
        int[] array = {8, 4, 9, 2, 23, 0};

        for (int index = 0; index < array.length; index++) {
            int minValue = array[index];
            int indexPosition = index;

            for (int nextIdex = index + 1; nextIdex < array.length; nextIdex++) {
                int currentValue = array[nextIdex];

                if (currentValue < minValue) {
                    minValue = currentValue;
                    indexPosition = nextIdex; // 8 с 4
                }
            }
            if (indexPosition != index) {
                array[indexPosition] = array[index]; //
                array[index] = minValue;
            }
        }
            for (int index = 0; index < array.length; index++){
                System.out.print(array[index] + " ");
            }
    }
}
