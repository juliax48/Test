package lesson9Generics;

public class HomeWork9Task1 {
    public static void main(String[] args) {
        Pair<Integer> pair1 = new Pair<>(5, 8);

        System.out.println("First element " + pair1.firstElement);
        System.out.println("Second element " + pair1.secondElement);
        pair1.swapElements();
        pair1.replaceFirst(15);
        pair1.replaceLast(18);
    }

}

class Pair<T> {
    T firstElement;
    T secondElement;

    public Pair(T firstElement, T secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }
    public void swapElements() {
        T tepm;
        tepm = secondElement;
        secondElement = tepm;
        System.out.println("Swap elemensts: " + secondElement + " , " + firstElement);
    }
    public void replaceFirst(T newElement) {
        firstElement = newElement;
        System.out.println("Replace first element " + newElement + " , " + secondElement);
    }
    public void replaceLast(T newElement) {
        System.out.println("Replace second element " + newElement + " , " + secondElement);
        secondElement = newElement;
    }
}
