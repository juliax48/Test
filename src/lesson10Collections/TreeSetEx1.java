package lesson10Collections;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetEx1 {
    public static void main(String[] args) {
        Set<Integer> tr = new TreeSet<>();
        tr.add(4);
        tr.add(3);
        tr.add(6);
        tr.add(89);
        tr.add(1);

        System.out.println(tr);

    }
}
