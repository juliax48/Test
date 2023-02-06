package lesson10Collections;

import java.util.*;

public class HomeWork10Task3 {
    public static void main(String[] args) {
        User user1 = new User("John", "Smith");
        User user2 = new User("John", "Smith");
        User user3 = new User("Adam", "Vector");
        User user4 = new User("Eva", "Vector");

        Set<User> stringSet = new HashSet<>();
        stringSet.add(user1);
        stringSet.add(user2);
        stringSet.add(user3);
        stringSet.add(user4);
        System.out.println(stringSet);

        Set<User> treeSet = new TreeSet<>();
        treeSet.addAll(stringSet);
        for (User user : treeSet) {
            System.out.print(user);
        }
    }

}

class User implements Comparable<User> {
    private String name;
    private String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return name.equals(user.name) && surname.equals(user.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return "[User {" + "name = " + name + " surname = " + surname + "}] ";
    }

    @Override
    public int compareTo(User o) {
        if (equals(o)) {
            return 0;
        }
        int compareSurname = this.surname.compareTo(o.surname);
        if (compareSurname != 0) {
            return compareSurname;
        }
        return this.name.compareTo(o.name);
    }

}
