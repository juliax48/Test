package lesson10Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkTask1 {
    public static void main(String[] args) {
       LinkedColL<Integer> linkedColL = new LinkedColL<>();

       LinkedElement<Integer> linkedElement = new LinkedElement<>();


     }
}

class LinkedElement<T> {
    private T value;
    private T previus;
    private T next;
}

class LinkedColL <T> {
    T element;

}


