package newtasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentArrayList {
    public static void main(String[] args) {
        Student student1 = new Student("Mark", 5);
        Student student2 = new Student("Tom", 4);
        Student student3 = new Student("Bob", 3);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        System.out.println("Before" + studentList);

        Collections.sort(studentList);

        System.out.println("After" + studentList);

        System.out.println(" ");

        for (Student st : studentList) {
            System.out.println(st);
        }

        System.out.println(" ");

        for (Student st : studentList) {
            if (st.getGrade() > 3) {
                System.out.println(st);
            }
        }
    }

}

class Student implements Comparable {
    List<Student> studentList;
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
        this.studentList = new ArrayList<>();
    }

    public List<Student> addStudentList(String name, int grade) {
        addStudentList(name, grade);
        return studentList;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
