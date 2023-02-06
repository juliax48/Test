package lesson8;

public class WorkLessonG {
    public static void main(String[] args) {
        Integer[] integers = new Integer[2];
        Conteirer<Integer> intergerConteirer = new Conteirer<>(new Integer[2]);
        Conteirer<Integer> integerConteirer = new Conteirer<>(integers);

        Conteirer<Boolean> booleanConteirer = new Conteirer<>(new Boolean[3]);

        System.out.println("booleanConteirer = " + booleanConteirer.getNumberOffElements());
        System.out.println("integerConteirer = " + integerConteirer.getNumberOffElements());

        boolean added = integerConteirer.addItem(4, 1);
        System.out.println("added = " + added);

        int foundIndex = integerConteirer.findIndex(1);
        System.out.println("foundIndex = " + foundIndex);

    }
}

class Conteirer<T> {
    private final T[] array;

    public Conteirer(T[] array) {
        this.array = array;
    }

    public T[] getArrays() {
        return array;
    }

    public int getNumberOffElements() {
        return array.length;
    }

    public boolean addItem(T item, int index) {
        if (index >= 0 && array.length > index) {
            array[index] = item;
            return true;
        }
        return false;
    }

    public int findIndex(T item) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == item) {
                return index;
            }
        }
        return -1;
    }

}