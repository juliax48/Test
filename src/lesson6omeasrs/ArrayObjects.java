package lesson6omeasrs;

public class ArrayObjects {
    public static void main(String[] args) {
        Men men1 = new Men("Bob");
        Men men2 = new Men("Sem");

    }
}

class Man {
    Men [] men;

}
class Men {
String name;

    public Men(String name) {
        this.name = name;
    }

}
