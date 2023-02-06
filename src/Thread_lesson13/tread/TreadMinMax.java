package Thread_lesson13.tread;

import java.util.Arrays;
import java.util.List;

public class TreadMinMax {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(4, 5);
        List<Integer> list2 = Arrays.asList(15, 7);

        oddAndEvenCounter(list1);
        System.out.println();
        oddAndEvenCounter(list2);

    }

    public static void oddAndEvenCounter (List<Integer> lists){
        int addCounter = 0;
        int evenCounter = 0;
        for (int element : lists){
            if (element %2 == 0){
                addCounter++;
            } else {
                evenCounter++;
            }
        }
        System.out.print(evenCounter);
        System.out.print(addCounter);

    }
}

class Count implements Runnable{

    @Override
    public void run() {

    }
}