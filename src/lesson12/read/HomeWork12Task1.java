package lesson12.read;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomeWork12Task1 {
private static final Charset STANDARD_CHARSETS = StandardCharsets.UTF_8;

public static void main(String[] args) {
        List<Integer> arrayIn1 = getRandomArray();
        List<Integer> arrayIn2 = getRandomArray();

        List<Integer> outArray = new ArrayList<>(2000);
        try {
            writeFile("in1.txt", arrayIn1);
            writeFile("in2.txt", arrayIn2);

            readFileToArray("in1.txt", outArray);
            readFileToArray("in2.txt", outArray);

            outArray.sort(Integer::compareTo);

            writeArrayToFile("out.txt", outArray);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static List<Integer> getRandomArray() {
        Random random = new Random();
        List<Integer> array = new ArrayList<>(1000);
        for (int index = 0; index < 1000; index++) {
            Integer element = random.nextInt(1, 1000);
            array.add(index, element);
        }
        return array;
    }

    public static void writeFile(String fileName, List<Integer> array) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, STANDARD_CHARSETS), 512)) {
            for (int value : array) {
                writer.write(value + "\n");
                writer.flush();
            }
        }
    }

    public static void readFileToArray(String fileName, List<Integer> array) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName, STANDARD_CHARSETS))) {
            String value = null;
            while ((value = reader.readLine()) != null) {
                value = value.trim();
                Integer intValue = Integer.parseInt(value);
                array.add(intValue);
            }
        }
    }

    public static void writeArrayToFile(String fileName, List<Integer> array) throws Exception {
        try (Writer bufferedWriter1 = new BufferedWriter(new FileWriter(fileName, STANDARD_CHARSETS), 512)) {
            for (int value : array) {
                bufferedWriter1.write(value + "\n");
            }
            bufferedWriter1.flush();
        }
    }

}




