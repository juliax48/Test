package lesson8;

public class HomeWork8Task1 {
    public static void main(String[] args) {
        Person person = new Person("Bob", 23, "Man", 85.4);
        person.display();

        Student student = new Student("Makr", 34, "man", 34.4, 2021);
        student.display();
    }

}

class Person {
    private String name;
    private final int age;
    private final String sex;
    private final double weight;

    public Person(String name, int age, String sex, double weight) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public double getWigth() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Person name is " + name + ", is " + age + ", sex "
                + sex + ", wigth " + weight + "kg");
    }
}

class Student extends Person {
    private int years;

    Student(String name, int age, String sex, double wigth, int years) {
        super(name, age, sex, wigth);
        this.years = years;
    }
    
    public int getYears() {
        int newYears = years + 1;
        return newYears;
    }

    @Override
    public void display() {
        System.out.println("Student " + getName() + ", is " + getAge() + ", sex " + getSex()
                + ", wight " + getWigth() + "kg " + ", studies in " + getYears() + " year");
    }
}
