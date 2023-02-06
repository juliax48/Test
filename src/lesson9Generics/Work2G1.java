package lesson9Generics;

import java.util.ArrayList;
import java.util.List;

public class Work2G1 {
    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("Old1");
        strings.add("Old 2");
        strings.add("Old 3");

        //fill(strings, "new");

        System.out.println(strings);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        //fill(numbers, 888);
        System.out.println(numbers);
    }
}

class TestClass {

    public static <T> void fill(List<T> list, T val) {
        for (int i = 0; i < list.size(); i++)
            list.set(i, val);
        System.out.println();
    }

}


//        T value = array[correntJ][correntI];
//        if (correntI + 1 < array[correntJ].length) {
//            correntI++;
//        } else {
//            correntI = 0;
//            correntJ++;
//        }
//        return value;



