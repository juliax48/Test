package lesson6omeasrs;

public class TestConstructor {
    public static void main(String[] args) {
        House house = new House(5, 5, "Mike");
        System.out.println("house.length = " + house.length);
        System.out.println("house.width = " + house.width);
        System.out.println("house.name = " + house.name);

        house.stay();
        house.stay(354, "fgg");
        int width = house.stay(323, "dfdf");
        System.out.println("width = " + width);
    }
}


class House {
    int length;
    int width;
    String name;

    House(int length, int width, String name) {
        this.length = length;
        this.width = width;
        this.name = name;
    }

    void stay() {
        System.out.println("Stay void ");

    }
    int stay(int length, String newName) {
        this.length = length;
        name = newName;
        System.out.println(this.length + name);
        return width;
    }
}
