package lesson5Arrays;

public class HomeWork5Task3 {
    public static void main(String[] args) {
        int[] array1 = {2, 4, 5, 10, 21};
        int[] array2 = {3, 7, 8, 12, 20};
        int[] newArray = new int[array1.length + array2.length];
        int minNumArray1 = array1[0];
        int minNumArray2 = array2[0];

        for (int indexRow = 0; indexRow < newArray.length; indexRow++) {
            for (int indexColumn = 0; indexColumn < array1.length; indexColumn++) {  // ar1 min элемент из массива1
                if (array1[indexColumn] > minNumArray1) {
                    minNumArray1 = array1[indexColumn];
                }
            }

            for (int indexRow2 = 0; indexRow2 < array2.length; indexRow2++) {   // ar2 min элемент из массива2
                if (array2[indexRow2] > minNumArray2) {
                    minNumArray2 = array2[indexRow2];
                }
            }
            if (minNumArray1 > minNumArray2) {
                newArray[indexRow] = minNumArray2;
            }
            if (minNumArray1 < minNumArray2) {
                newArray[indexRow] = minNumArray1;
            }
//            newArray[indexRow2] = Arrays.fill(minNumArray1));
//            System.out.print(newArray[indexRow2] + " ");
        }
    }
}


