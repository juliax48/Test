package lesson7String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeWork7Task3 {
    public static void main(String[] args) {
        String text = "Listen to the news from today, " +
                "read the text at the same time! " +
                "Listen to the news from today - without reading the text.";

        int countSignPinning = 0;

        Pattern signPinning = Pattern.compile("\\p{P}");
        Matcher matcher = signPinning.matcher(text);

        while (matcher.find()){
            countSignPinning++;
        }
        System.out.println("Count sign in text = " + countSignPinning);
    }

}
