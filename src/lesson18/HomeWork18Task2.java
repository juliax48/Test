package lesson18;

import java.lang.annotation.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class HomeWork18Task2 {
    public static void main(String[] args) throws NoSuchFieldException {
        Customer customer = new Customer("Bob", "Redif");


    }


}


class Customer {
    private final String firstName;
    private final String lastName;


    public Customer(@PatternValidationFistName(patternFirstName = "[a-zA-Z]{1,25}", errorMassageFirstName = "pattern ist not found") String firstName,
                    @PatternValidationLastName(patternLastName = "[a-zA-Z1-9]{3,10}", errorMassageLastName = "pattern ist not found") String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Validated {

}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@interface PatternValidationFistName {
    String patternFirstName();
    String errorMassageFirstName();
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@interface PatternValidationLastName {
    String patternLastName();
    String errorMassageLastName();
}