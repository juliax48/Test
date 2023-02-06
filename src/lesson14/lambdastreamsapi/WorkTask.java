package lesson14.lambdastreamsapi;

import java.util.ArrayList;
import java.util.List;

public class WorkTask {
    public static void main(String[] args) {
        List<Animal> animalList = getAnimals();

        List<Animal> her = new ArrayList<>();
        for (Animal animal : her){
            if (animal.getName().equals(Classification.HER)){
                her.add(animal);
            }
        }
        her.forEach(System.out::println);
    }

    public static List<Animal> getAnimals() {
        return List.of(
                new Animal("slon", 20, Classification.HER),
                new Animal("Lion", 40, Classification.ALL),
                new Animal("Horse", 50, Classification.HER),
                new Animal("Dino", 100, Classification.XICZ)
                );
    }
}


enum Classification {
    HER, XICZ, ALL
}

class Animal {
    private final String name;
    private final int age;
    private final Classification classification;

    public Animal(String name, int age, Classification classification) {
        this.name = name;
        this.age = age;
        this.classification = classification;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Classification getClassification() {
        return classification;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", classification=" + classification +
                '}';
    }
}