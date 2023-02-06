package lesson8;

public class HomeWork8Task2 {
    public static void main(String[] args) {
        Rose rose1 = new Rose("Red", 5, 11);
        Rose rose2 = new Rose("Blue", 10, 12);
        Rose rose3 = new Rose("Green", 15, 21);
        Tulip tulip1 = new Tulip("Pink", 2, 21);
        Tulip tulip2 = new Tulip("Black", 4, 21);
        Tulip tulip3 = new Tulip("Red", 3, 21);

        Bouquet bouquet1 = new Bouquet(5);
        bouquet1.addFlower(tulip1);
        bouquet1.addFlower(tulip2);
        bouquet1.addFlower(tulip3);
        bouquet1.addFlower(rose1);
        bouquet1.addFlower(rose3);
        bouquet1.addFlower(rose2);

        System.out.println("Bouquet costs " + bouquet1.getPrice() + " $");
        bouquet1.printColors();
        System.out.println("Days live of bouquet is " + bouquet1.getDaysLive() + " days");
    }
}


class Bouquet {
    private Flower[] flowers; // это объявление, без инициалицияции

    private int currentElement; // текущий элемент массива
    private int dayOfFlowers;

    public Bouquet(int numberOfFlowers) {
        this.flowers = new Flower[numberOfFlowers];
        this.currentElement = 0; // какой эленлемент массива в кот могу добавить цветок
    }

    public boolean addFlower(final Flower flower) { // объявляет метод. контракт, декларация о намериниях
        if (currentElement == flowers.length) { // условие, синтекс консрукция.
            return false;
        }
        flowers[currentElement] = flower;
        currentElement++; // передвигаем указатель +1
        return true;
    }

    public int getPrice() {
        int finalPrice = 0;
        for (Flower flower : flowers) {
            finalPrice += flower.getCost();
        }
        return finalPrice;
    }

    public void printColors() {
        System.out.print("Bouquet consists from ");
        for (Flower flower : flowers) {
            System.out.print(flower.getColor() + " ");
        }
        System.out.print("colors");
        System.out.println(" ");
    }

    public int getDaysLive() {
        int maxday = 0;
        for (Flower flower : flowers) {
            if (maxday < flower.getDaysLive()) {
                maxday = flower.getDaysLive();
            }
        }
        return maxday;
    }

}

abstract class Flower {
    private final String color;
    private final String type;
    private final int cost;
    private final int daysLive;

    public Flower(String color, String type, int cost, int daysLive) {
        this.color = color;
        this.type = type;
        this.cost = cost;
        this.daysLive = daysLive;
    }

    public int getCost() {
        return cost;
    }

    public String getColor() {
        return color;
    }

    public int getDaysLive() {
        return daysLive;
    }
}

class Rose extends Flower {
    public Rose(String color, int cost, int daysLive) {
        super(color, "Rose", cost, daysLive);
    }
}

class Tulip extends Flower {
    public Tulip(String color, int cost, int daysLive) {
        super(color, "Tulip", cost, daysLive);
    }
}



