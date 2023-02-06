package lesson12.read;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HomeWork12Task2 {
    public static void main(String[] args) {
        String text = "In the middle of December, we buy a New Year’s tree, \n" +
                "which we decorate with my parents. It’s a tradition because it \n" +
                "brings us together and we really have fun doing it. \n" +
                "Also, before New Year’s Day, we always clean the house and create a festive atmosphere. \n" +
                "I like to decorate the house with paper snowflakes, candles, and garlands.";

        try {
            writeFile(text);
        } catch (Exception ex){
            ex.printStackTrace();
        }

        System.out.println("Number of words in the text: " + countWordsText(text));
        System.out.println("Number of sign pinning in the text: " + countSignPinning(text));
    }

    public static void writeFile(String text) throws Exception {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Text.txt", StandardCharsets.ISO_8859_1))) {
            bufferedWriter.write(text);
            bufferedWriter.flush();
        }
    }

    public static int countWordsText(String text) {
        int countWordsText = 0;

        Pattern words = Pattern.compile("(?U)[^\\W_]+");
        Matcher matcherWords = words.matcher(text);

        while (matcherWords.find()) {
            countWordsText++;
        }
        return countWordsText;
    }

    public static int countSignPinning(String text) {
        int countSignPinning = 0;

        Pattern signPinning = Pattern.compile("\\p{P}");
        Matcher matcher = signPinning.matcher(text);

        while (matcher.find()) {
            countSignPinning++;
        }
        return countSignPinning;
    }

}



