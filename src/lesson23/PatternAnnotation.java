package lesson23;

import java.lang.annotation.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternAnnotation {
    public static void main(String[] args) throws
            NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        User user = create(User.class, "Sara");
        User user1 = create(User.class, "Sara 123");
        System.out.println("user = " + user);

        Customer customer = create(Customer.class, "12345");
        System.out.println("customer = " + customer);
    }

    private static <T> T create(Class<T> clazz, String value) throws
            NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<T> constructor = clazz.getConstructor(String.class);

        boolean shouldBeValidated = getAnnotation(clazz.getAnnotations(), Validated.class) != null;

        if (shouldBeValidated) {
            Parameter parameter = constructor.getParameters()[0];

            NotNullValidation notNullValidation = getAnnotation(parameter.getAnnotations(), NotNullValidation.class);
            if (notNullValidation != null && value == null) {
                throw new NullPointerException(notNullValidation.errorMessage());
            }

            PatternValidation patternValidation = getAnnotation(parameter.getAnnotations(), PatternValidation.class);
            if (patternValidation != null) {
                Pattern pattern = Pattern.compile(patternValidation.pattern());
                Matcher matcher = pattern.matcher(value);

                if (!matcher.matches()) {
                    String errorMessage = String.format(patternValidation.errorMessagePattern(), value, patternValidation.pattern());
                    throw new IllegalArgumentException(errorMessage);
                }
            }

        }

        return constructor.newInstance(value);
    }

    private static <T extends Annotation> T getAnnotation(final Annotation[] annotations, Class<T> annotationType) {
        T requiredAnnotation = null;
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(annotationType)) {
                requiredAnnotation = (T) annotation;

            }
        }
        return requiredAnnotation;
    }
}

@Validated
class Customer {

    private final String id;

    public Customer(@PatternValidation(pattern = "^[0-9]{1,5}$") @NotNullValidation(errorMessage = "Customer id is null") final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                '}';
    }
}

class Base {
}

@Validated
class User extends Base implements Comparable<User> {

    private final String name;

    public User(@PatternValidation(pattern = "^[a-zA-Z]+$") @NotNullValidation(errorMessage = "User name is null") final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(final User o) {
        return name.compareTo(o.name);
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Validated {

}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@interface NotNullValidation {

    String errorMessage() default "Parameter is null";

}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@interface PatternValidation {

    String pattern();

    String errorMessagePattern() default "Parameter [%s] is not matched by pattern [%s]";

}

