package lessonARRAY_SSORT;

import java.util.Arrays;

public class SortMinMax {
    public static void main(String[] args) {
        int[] array = {3,4,5,6,34,12,3,1};

        Arrays.sort(array);

        System.out.println(Arrays.toString(array));

        int max = array[array.length-1]-array[array.length-1];

        System.out.println(max);
    }
}
