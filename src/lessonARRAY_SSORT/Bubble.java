package lessonARRAY_SSORT;

public class Bubble {
    public static void main(String[] args) {
        int[] array = {4, 5, 2, 34, 1, 5};

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {// in последний элемент массива
                if (array[j - 1] > array[j]) {
                    int tepm = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tepm;
                }
            }
        }
        for (int k = 0; k < array.length; k++) {
            System.out.print(array[k] + " ");
        }
    }
}
