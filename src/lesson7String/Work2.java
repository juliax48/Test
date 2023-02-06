package lesson7String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Work2 {
    public static void main(String[] args) {
        String str = "Hello, Mark!";

        Pattern pattern = Pattern.compile("!");
        Matcher matcher = pattern.matcher(str);
        matcher.find();
        while (matcher.find()){
            System.out.println(matcher.group());}

    }
}
