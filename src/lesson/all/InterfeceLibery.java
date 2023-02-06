package lesson.all;

public class InterfeceLibery {
    public static void main(String[] args) {
        Library cityLibrary = new CityLibrary();
        Library villageLibrary = new VillageLibrary();

        cityLibrary.readBook("Book");
        cityLibrary.returnBook("Another Book");
        cityLibrary.writeBook("Book");

        villageLibrary.readBook("Book");
        villageLibrary.returnBook("Another Book");
        villageLibrary.writeBook("Book");
    }

}

interface Library {

    void readBook(String bookName);

    void writeBook(String bookName);

    void returnBook(String bookName);

}

abstract class AbstractLibrary implements Library {

    @Override
    public void readBook(String bookName) {
        System.out.println("Read book is the same for all");
    }

    @Override
    public void writeBook(String bookName) {
        System.out.println("Write book is the same for all");
    }
}

class CityLibrary extends AbstractLibrary {
    @Override
    public void returnBook(String bookName) {
        System.out.println("City Library");
    }
}

class VillageLibrary extends AbstractLibrary {

    @Override
    public void returnBook(String bookName) {
        System.out.println("Village Library");
    }
}

