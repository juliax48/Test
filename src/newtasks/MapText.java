package newtasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapText {
    public static void main(String[] args) {
        System.out.println("Enter text");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        System.out.println(text);

        Map<Integer, Integer> integerIntegerMap = new HashMap<>();

        System.out.println(integerIntegerMap);

        System.out.println(integerIntegerMap.containsKey(1));
    }
}
