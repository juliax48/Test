package lesson10Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCadeEx1 {
    public static void main(String[] args) {
        Map<Student, Double> map = new HashMap<>();
        Student st1 = new Student("Dod", "Ivanov", 3);
        Student st2 = new Student("Bob", " Petros", 4);
        Student st3 = new Student("Der", " Petros", 5);

        st3 = new Student("Der", " Petros", 5);

        map.put(st1, 4.3);
        map.put(st2, 4.8);
        map.put(st3, 3.6);

        System.out.println(map);

    }
}

class Student {
    String name;
    String surname;
    int course;

    public Student(String name, String surname, int course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cuorse=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && Objects.equals(name, student.name) && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, course);
    }
}