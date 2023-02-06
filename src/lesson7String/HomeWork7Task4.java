package lesson7String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeWork7Task4 {
    public static void main(String[] args) {
        String str = "bla-blabla@@blabla.bla  myemail@gmail.com email a.petrov@gmail.com.au  coder4575@yandex.ru";

        Pattern pattern = Pattern.compile("[a-zA-Z0-9_\\-.]+@([a-zA-Z0-9_\\-.]+\\.)+[a-zA-Z]{2,6}");
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            System.out.println(str.substring(matcher.start(), matcher.end()));
        }
    }
}