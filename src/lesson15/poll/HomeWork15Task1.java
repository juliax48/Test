package lesson15.poll;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

public class HomeWork15Task1 {
    public static void main(String[] args) {
        Integer[][] matrix = createMatrix();

        ExecutorService executorService = new ThreadPoolExecutor(1,
                2,
                100,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(2),
                (runnable, executor) -> System.out.println("Element can not be processed. " + runnable));

        Callable<Integer> sumMultipleRows = () -> Math.toIntExact(multipleRows(matrix));
        Callable<Integer> sumMultipleColumn = () -> Math.toIntExact(multipleColumn(matrix));

        Future<Integer> futureSumMultipleRows = executorService.submit(sumMultipleRows);
        Future<Integer> futureSumMultipleColumn = executorService.submit(sumMultipleColumn);
        executorService.shutdown();

        Integer resultSumMultipleRows = getResult(futureSumMultipleColumn);
        Integer resultSumMultipleColumn = getResult(futureSumMultipleRows);

        printMatrix(matrix);

        System.out.println("Sum of rows Array is " + resultSumMultipleRows);
        System.out.println("Sum of columns Array is " + resultSumMultipleColumn);
    }

    public static Integer getResult(Future<Integer> future) {
        try {
            while (!future.isDone()) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            return future.get();

        } catch (Exception ex) {
            throw new RuntimeException("Failed to get result");
        }
    }

    public static Integer[][] createMatrix() {
        Integer[][] matrix;
        Random random = new Random();
        System.out.println("Please, create matrix size n*m, enter two numbers from 0 to 10 :");

        try (Scanner scanner = new Scanner(System.in)) {
            int rowMatrix = scanner.nextInt();
            int columnMatrix = scanner.nextInt();
            matrix = new Integer[rowMatrix][columnMatrix];
            scanner.close();


            for (int row = 0; row < matrix.length; row++) {
                for (int column = 0; column < matrix[row].length; column++) {
                    matrix[row][column] = random.nextInt(2) + 1;
                }
            }
            return matrix;
        } catch (InputMismatchException ex) {
            throw new RuntimeException("Matrix is not creative, please, enter two numbers from 0 to 10");
        }
    }

    public static void printMatrix(Integer[][] matrix) {
        for (Integer[] integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }
    }

    public static long multipleRows(Integer[][] matrix) {
        int sumOfMultipleRows = 0;
        for (int row = 0; row < matrix.length; row++) {
            int multiRows = 1;
            for (int column = 0; column < matrix[row].length; column++) {
                multiRows *= matrix[row][column];
            }
            sumOfMultipleRows += multiRows;
        }
        return sumOfMultipleRows;
    }

    public static long multipleColumn(Integer[][] matrix) {
        int sumOfMultipleColumn = 0;

        for (Integer[] integers : matrix) {
            int result = 1;
            for (int column = 0; column < integers.length; column++) {
                result *= integers[column];
            }
            sumOfMultipleColumn += result;
        }
        return sumOfMultipleColumn;
    }

}



