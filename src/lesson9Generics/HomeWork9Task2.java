package lesson9Generics;

public class HomeWork9Task2 {
    public static void main(String[] args) {
        Integer[][] array = {{1, 2, 3}, {4, 5, 6}};
        Iterator<Integer> iterator = new Iterator<>(array);

        System.out.print("Array: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }

}

class Iterator<T> {
    T[][] array;
    int currentRow = 0;
    int currentColumn = -1;

    public Iterator(T[][] array) {
        this.array = array;
    }

    public boolean hasNext() {
        return currentColumn + 1 != array[currentRow].length || currentRow + 1 != array.length;
    }

    public T next() {
        if (currentColumn + 1 < array[currentRow].length) {
            currentColumn++;
        } else {
            currentColumn = 0;
            currentRow++;
        }
        return array[currentRow][currentColumn];
    }
}

