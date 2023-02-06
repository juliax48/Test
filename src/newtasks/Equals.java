package newtasks;

import java.util.Objects;

public class Equals {
    public static void main(String[] args) {
        B b1 = new B("Ada1", "P1");
        B b2 = new B("Ada1", "P1");

        System.out.println(b1==b2);
        System.out.println(b1.equals(b2));
    }
}

class A {
    String name;

    public A(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) { // ставнивает только поле name!
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return name.equals(a.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

class B extends A {
    String text;

    public B(String name, String text) {
        super(name);
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        B b = (B) o;
        return text.equals(b.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), text);
    }
}
