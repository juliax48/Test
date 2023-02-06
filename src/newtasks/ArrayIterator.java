package newtasks;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class ArrayIterator {
    public static void main(String[] args) {
        ArrayList<Integer> randomList = new ArrayList<>(30);
        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            randomList.add(random.nextInt(0, 20));
        }

        System.out.println("Random list: " + randomList);

        Stream.of(randomList)
                .forEach(System.out::println);

        System.out.println("Max value: " + getMaxValue(randomList));


    }

    public static int getMaxValue(ArrayList<Integer> numbers) {
        Iterator<Integer> iterator = numbers.iterator();
        int maxValue = iterator.next();

        while (iterator.hasNext()) {
            int element = iterator.next();
            if (element > maxValue) {
                maxValue = element;
            }
        }
        return maxValue;
    }
}
