package lesson18.anatation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class ShopStoreAnnotation {
    public static void main(String[] args) {
        Store store = new Store();

        Set<Product> products = new HashSet<>();

        for (int index = 0; index<10; index++){
            products.add(new Product());
        }
    }




}


class Store {
    @ProductSize(max = 500, min = 10)
    private Set<Product> products;

    public Set<Product> getProducts() {
        return products;
    }
}

class Product {

}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
@interface ProductSize {
    int max();
    int min();
}