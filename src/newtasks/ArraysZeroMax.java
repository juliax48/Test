package newtasks;


import java.util.Arrays;

public class ArraysZeroMax {
    public static void main(String[] args) {
        int[] numbers = {0, 0, 9};
        System.out.println("numbers" + Arrays.toString(numbers));

        int maxOdd = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (i > maxOdd) {
                maxOdd = numbers[i];
            }
        }
        System.out.println("maxOdd = " + maxOdd);

        for (int i = 0; i < numbers.length; i++) {
            if (i == 0) {
                numbers[i] = maxOdd;
            }
            System.out.println("i "+ i + Arrays.toString(numbers));
        }
    }
}


//
//        List<Integer> list = getArray();
//        System.out.println(list);
//
//        Optional maxNumberOdd = list.stream()
//                .filter((x) -> x % 2 != 0)
//                .max(Integer::compareTo); // .max((x, y)-> x.compareTo(y));
//        System.out.println("maxNumberOdd = " + maxNumberOdd);
//
//
//        for (Integer l : list) {
//            if (l == 0) {
//                l = Integer(maxNumberOdd);
//            }
//
//        }
//
//
//    }
//
//    public static List<Integer> getArray() {
//        Random random = new Random();
//        List<Integer> integerList = IntStream.range(0, 10)
//                .map(value -> random.nextInt(10))
//                .boxed().toList();
//        return integerList;
//    }
//
//    public static void findMaxOddNumber(List<Array> list) {
//
//    }
//}


