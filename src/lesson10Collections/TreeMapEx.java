package lesson10Collections;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapEx {
    public static void main(String[] args) {
        TreeMap<Integer, Phone> treeMap = new TreeMap<>();
        Phone phone1 = new Phone("Nokia", "One", 5);
        Phone phone2 = new Phone("Iphone", "I", 10);
        Phone phone3 = new Phone("Iphone", "I", 11);
        Phone phone4 = new Phone("Iphone", "I", 12);
        Phone phone5 = new Phone("LG", "Z", 1);
        Phone phone6 = new Phone("Sumsung", "Zero", 6);

        treeMap.put(12, phone4);
        treeMap.put(10, phone2);
        treeMap.put(1, phone5);
        treeMap.put(6, phone6);
        treeMap.put(11, phone3);
        treeMap.put(5, phone1);


        }


    }

class Phone {
    String brand;
    String name;
    int id;

    public Phone(String brand, String name, int id) {
        this.brand = brand;
        this.name = name;
        this.id = id;
    }
}
