package lesson5Arrays;

import java.util.Random;

public class ClassWork4 {
    public static void main(String[] args) {
        int[][] array = new int[5][5];

        Random random = new Random();
        for (int rowIndex = 0; rowIndex < array.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < array.length; columnIndex++) {
                int randomInt = random.nextInt(5);
                array[rowIndex][columnIndex] = randomInt;
                System.out.print(randomInt + " ");
            }
            System.out.println();
        }

        for (int rowIndex = 0; rowIndex < array.length; rowIndex++){

            for (int columnIndex = 0; columnIndex < array[rowIndex].length; columnIndex++){
                int resultMultiplication = 1;

                for (int currentColumn = columnIndex, currentRow = rowIndex; currentRow < array.length && currentColumn < array[currentRow].length;
                     currentColumn++, currentRow++){
                    int currentColumnValue = array[currentRow][currentColumn];
                    resultMultiplication = resultMultiplication * currentColumnValue ;
                }

                System.out.print(resultMultiplication);
            }


        }
    }
}
