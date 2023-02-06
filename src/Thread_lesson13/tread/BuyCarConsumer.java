package Thread_lesson13.tread;

import java.util.*;

public class BuyCarConsumer {
    public static void main(String[] args) {
        Random random = new Random();

        People people = new People(2);
        Fabric fabric = new Fabric(1, 2);

        for (int person = 1; person <= 2; ) {
            try {
                int randomCarNumber = random.nextInt(2) + 1;

                if (fabric.allCarsBought()) {
                    break;
                } else if (fabric.isCarBought(randomCarNumber)) {
                    people.buyCar(person, randomCarNumber);
                    System.out.println("Person " + person + " bought " + randomCarNumber);
                    person++;
                } else {
                    System.out.println("Car with number " + randomCarNumber + " is bought");
                }

            } catch (CarNumberException ex) {
                System.err.println("Person " + person + " could not buy car due to " + ex.getMessage());
            } catch (PersonNumberException ex) {
                System.err.println(ex.getMessage());
                System.out.println("Person " + person + " can't be processed");
            }
        }

        System.out.println(people.getPersonCarMap());
    }
}

class Fabric {
    private final Set<Integer> providedCarNumbers;
    private final int minimumCarNumber;
    private final int maximumCarNumber;

    public Fabric(int minimumCarNumber, int maximumCarNumber) {
        this.minimumCarNumber = minimumCarNumber;
        this.maximumCarNumber = maximumCarNumber;
        this.providedCarNumbers = new HashSet<>(maximumCarNumber - minimumCarNumber + 1);
    }

    public boolean allCarsBought() {
        return maximumCarNumber - minimumCarNumber + 1 == providedCarNumbers.size();
    }

    public boolean isCarBought(int carNumber) throws CarNumberException {
        if (carNumber >= minimumCarNumber && carNumber <= maximumCarNumber) {
            if (providedCarNumbers.contains(carNumber)) {
                return false;
            } else {
                providedCarNumbers.add(carNumber);
                return true;
            }
        }

        throw new CarNumberException("Number is not valid, it must be between " + minimumCarNumber + " - " + maximumCarNumber);
    }

}

class CarNumberException extends Exception {

    public CarNumberException(String message) {
        super(message);
    }
}


class People {

    private final int peopleAmount;
    private final Map<Integer, Integer> personCarMap;

    public People(int peopleAmount) {
        this.peopleAmount = peopleAmount;
        this.personCarMap = new TreeMap<>();
    }

    public Map<Integer, Integer> getPersonCarMap() {
        return personCarMap;
    }

    public int findPeopleByCar(int carNumber) throws PersonNotFoundException {
        for (Map.Entry<Integer, Integer> entry : personCarMap.entrySet()) {
            if (entry.getValue().equals(carNumber)) {
                return entry.getKey();
            }
        }

        throw new PersonNotFoundException("Person for car number " + carNumber + " not found");
    }


    public boolean buyCar(int personNumber, int carNumber) throws PersonNumberException {
        if (personNumber < 1 || personNumber > peopleAmount) {
            throw new PersonNumberException("Number person must be between 1 " + peopleAmount);
        }

        if (personCarMap.containsKey(personNumber)) {
            return false;
        } else {
            personCarMap.put(personNumber, carNumber);
            return true;
        }
    }

}

class PeopleException extends Exception {
    public PeopleException(String message) {
        super(message);
    }
}

class PersonNotFoundException extends PeopleException {
    public PersonNotFoundException(String message) {
        super(message);
    }
}

class PersonNumberException extends PeopleException {
    public PersonNumberException(String message) {
        super(message);
    }
}
