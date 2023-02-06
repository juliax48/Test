package newtasks;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class ReadNumber {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        List<Integer> integerList = new ArrayList<>(20);

        for (int i = 0; i < 20; i++) {
            integerList.add(random.nextInt(10) + 1);
        }
        System.out.println(integerList);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("file numbers.txt", StandardCharsets.ISO_8859_1), 512)) {

            for (int value : integerList) {
                bufferedWriter.write(value + " ");
                bufferedWriter.flush();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        File f1 = new File("file numbers.txt");
        System.out.println(f1.getAbsolutePath());


    }
}

