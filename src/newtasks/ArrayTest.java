package newtasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ArrayTest {
    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println(list);

        list.sort(Comparator.reverseOrder());

        System.out.println(list);

        ArrayList<String> list001 = new ArrayList<String>();
        list001.add("a");
        list001.add("a");
        list001.add("b");

        System.out.println(list.equals(list001));
    }
}
