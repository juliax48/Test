package lesson.all;

import java.lang.annotation.Retention;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExceptionPattern {
    public static void main(String[] args) {
        NameValidator nameValidator = (name) -> {
            Pattern pattern = Pattern.compile("[a-zA-Z]{1,10}");
            Matcher matcher = pattern.matcher(name);
            if (!matcher.matches()) {
                throw new NameValidatorException(name + " is not valid!");
            }
        };

        try (Scanner scanner = new Scanner(System.in)) {
            for (int attempts = 1; attempts <= 3; attempts++) {
                System.out.println("Enter your name. Your attempt is: " + attempts);
                String name = scanner.nextLine();

                try {
                    nameValidator.validateName(name);
                    System.out.println("Your name is good");
                    break;
                } catch (NameValidatorException e) {
                    System.out.println(e.getMessage());
                    if (attempts == 3) {
                        System.out.println("You write a wrong name. Game is over.");
                    } else {
                        System.out.println("Your name is not good, you must to write only letters and length must be between 1 and 10");
                    }
                }
            }
        }
    }
}

@FunctionalInterface
interface NameValidator {

    void validateName(String name) throws NameValidatorException;
}

class NameValidatorException extends Exception {

    public NameValidatorException(final String message) {
        super(message);
    }
}