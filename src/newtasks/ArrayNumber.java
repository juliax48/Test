package newtasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class ArrayNumber {
    public static void main(String[] args) {
        ArrayList<Integer> integerList = new ArrayList<>(30);
        Random random = new Random();

        for (int index = 0; index < 30; index++) {
            integerList.add(random.nextInt(0, 20));
        }

        System.out.println(integerList);
        System.out.println(uniqueNumbers(integerList));
    }

    public static ArrayList<Integer> uniqueNumbers(ArrayList<Integer> integers) {
        ArrayList<Integer> uniqueNumbers = new ArrayList<>();

        for (int i = 0; i < integers.size(); i++) {
            if (!uniqueNumbers.contains(integers.get(i))) {
                uniqueNumbers.add(integers.get(i));
            }
        }
        return uniqueNumbers;
    }
}



