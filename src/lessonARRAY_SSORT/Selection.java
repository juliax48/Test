package lessonARRAY_SSORT;

public class Selection {
    public static void main(String[] args) {
        int[] array = {4, 5, 2, 3, 1, 5};

        System.out.print("Not Sort ");
        for (int x : array)
            System.out.print(x + " ");

        System.out.println();

        for (int i = 0; i < array.length; i++) {
            int pos = i;
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    pos = j;
                    min = array[j];
                }
            }
            array[pos] = array[i];
            array[i] = min;
        }
        System.out.println();
        for (int x : array)
        System.out.print(x + " ");
    }
}
