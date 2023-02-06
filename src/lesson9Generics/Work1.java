package lesson9Generics;

public class Work1 {
    public static void main(String[] args) {
MyListClass one = new MyListClass();
one.add(4);
one.add(5);
    }
}

class MyListClass {
    private Object[] data;
    private int count;

    public MyListClass() {
        this.data = new Object[10];
        this.count = 0;
    }

    public void add(int x) {
        this.data[count] = 0;
        count++;
    }

    public Object[] getData() {
        return data;
    }
}

