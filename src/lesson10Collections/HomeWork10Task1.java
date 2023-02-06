package lesson10Collections;

import java.util.HashMap;
import java.util.Map;

public class HomeWork10Task1 {
    public static void main(String[] args) {
        Integer[] array = {2, 2, 3, 3, 4, 5, 5};

        var result = arrayToMap(array);
        System.out.println(result);
    }

    public static <K> Map<K, Integer> arrayToMap(K[] ks) {
        Map<K, Integer> kMap = new HashMap<>();
        for (K k : ks) {
            if (!kMap.containsKey(k)) {
                kMap.put(k, 0);
            }
            kMap.put(k, kMap.get(k) + 1);
        }
        return kMap;
    }

}
