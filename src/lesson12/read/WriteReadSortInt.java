package lesson12.read;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WriteReadSortInt {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(10);

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            integerList.add(random.nextInt(10) + 1);
        }
        System.out.println(integerList);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("listNum.txt", StandardCharsets.UTF_8))) {
            for (Integer num :integerList) {
                bufferedWriter.write(num+ "\n");
            }
            bufferedWriter.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }





    }
}
