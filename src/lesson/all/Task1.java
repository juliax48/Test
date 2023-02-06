package lesson.all;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Set<Integer> setElemets = new LinkedHashSet<>();
        setElemets.add(5);
        setElemets.add(3);
        setElemets.add(1);

        toString(setElemets);

        Map<String, Integer> map = new HashMap<>();
        map.put("Artem", 4);
        map.put("Egor", 5);

        toString(map);

    }

    public static <T> void toString (Collection <T> elements ){
        Iterator <T> iterator = elements.iterator();

        while (iterator.hasNext()){
            T element = iterator.next();
            System.out.print(element + " ");
        }
    }

    public static <K,V> void toString (Map <K,V> elements ){

        Iterator <Map.Entry<K,V>> iterator = elements.entrySet().iterator();
        toString(elements.entrySet());

//        while (iterator.hasNext()){
//            Map.Entry<K,V> element = iterator.next();
//            System.out.println();
//            System.out.print("element = " + element);
//        }
    }

}
