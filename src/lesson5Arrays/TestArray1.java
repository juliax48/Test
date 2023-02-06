package lesson5Arrays;

public class TestArray1 {
    public static void main(String[] args) {
        String[] array = {"Каждый ", "охотник ", "желает ", "знать ", "где ", "сидит ", "фазан "};
        System.out.print("Array 1: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print( "\n"+"Array 2: ");
        int n = array.length;
        //Переменная, которая будет использоваться при обмене элементов
        String temp;

        for (int i = 0; i < n/2; i++) {
            temp = array[n-i-1]; // как нати противоположное число в массиве
            array[n-i-1] = array[i];
            array[i] = temp;
        }
        //Выводим конечный массив в консоль
        for (int i=0; i<array.length; i++){
            System.out.print(array[i]);
        }
    }
}
