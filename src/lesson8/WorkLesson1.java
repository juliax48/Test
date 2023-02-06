package lesson8;

public class WorkLesson1 {
    public static void main(String[] args) {
        PlaneOne plane = new PlaneOne (45);
        plane.fly();

        Boeing boeing = new Boeing(23,50);
        boeing.fly();

        PlaneOne planeboeing = new Boeing(23,3);
        planeboeing.fly();

        Object objectboing = planeboeing;
        planeboeing.fly(); // тут не должно показывать метод.
        }
}

class PlaneOne {
    private int length;

    public PlaneOne (int length) {
        this.length = length;
    }

    public void fly() {
        System.out.println("Fly to ...");
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}

class Boeing extends PlaneOne {
    private int weight;

    Boeing (int length, int weight) {
        super(length);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public void fly() {
        System.out.println("boing fly");
    }
}