package lesson10Collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetEx1 {
    public static void main(String[] args) {
        HashSet<Integer> one = new HashSet<>();
        one.add(1);
        one.add(2);
        one.add(3);
        HashSet<Integer> one2 = new HashSet<>();
        one.add(3);
        one.add(2);
        one.add(1);
        HashSet<Integer> ubion = new HashSet<>(one);
        ubion.addAll(one);
        System.out.println(ubion);

        Set<String> set = new HashSet<>();
        set.add("Red");
        set.add("Dad");
        set.add("Igor");
        set.add("Bod");
        System.out.println(set.size());

        System.out.println(set);
        for (String e : set) {
            System.out.print(e + " ");
        }

        int[] array = {4, 5, 6, 7};

        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(4);
        integerSet.add(8);
        integerSet.add(5);
        System.out.println(integerSet);

        Us us1 = new Us("John", "Smith");
        Us us2 = new Us("John", "Smith");
        Us us3 = new Us("Adam", "Vector");

        Set <Us> treeSet = new TreeSet<>();
        treeSet.add(us1);
        treeSet.add(us2);
        treeSet.add(us3);
        treeSet.add(us1);
        treeSet.add(us2);

        System.out.println(treeSet);

    }
}

class Us implements Comparable <Us> {
    private String name;
    private String surname;

    public Us(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public int compareTo(Us o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Us{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}