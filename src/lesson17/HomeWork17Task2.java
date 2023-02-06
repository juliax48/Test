package lesson17;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class HomeWork17Task2 {
    public static void main(String[] args) {
        Product product1 = new Product("Iphone12", 99, 500);
        Product product2 = new Product("Galaxy", 65, 50);
        Product product3 = new Product("Ipad10", 70, 400);
        Product product4 = new Product("GalaxyTab", 50, 250);

        Category category1 = new Category("Mobile phones");
        category1.addProduct(product1);
        category1.addProduct(product2);

        Category category2 = new Category("Tablets");
        category2.addProduct(product3);
        category2.addProduct(product4);

        Basket basket = new Basket();
        basket.addToBasket(product1);
        basket.addToBasket(product2);
        basket.addToBasket(product3);
        basket.addToBasket(product4);
        basket.submitOrder();

        System.out.println("Basket order date: " + basket.getOrderDate());
        System.out.println("Basket order: " + basket.getBasket());
    }
}


class Product {
    private final String name;
    private final int rating;
    private final double prise;

    public Product(String name, int rating, double prise) {
        this.name = name;
        this.rating = rating;
        this.prise = prise;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", prise=" + prise +
                '}';
    }
}

class Category {
    private final String name;
    private final List<Product> products;

    public Category(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public List<Product> addProduct(Product product) {
        products.add(product);
        return products;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}

class Basket {
    private final List<Product> basket;
    private ZonedDateTime orderZoneDate;

    public Basket() {
        this.basket = new ArrayList<>();
    }

    public List<Product> getBasket() {
        return basket;
    }

    public ZonedDateTime getOrderDate() {
        return orderZoneDate;
    }

    public List<Product> addToBasket(Product product) {
        basket.add(product);
        return basket;
    }

    public void submitOrder() {
        orderZoneDate = ZonedDateTime.now();
    }

    @Override
    public String toString() {
        return "Basket{" +
                "basket=" + basket +
                '}';
    }
}
