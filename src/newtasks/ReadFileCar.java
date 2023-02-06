package newtasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ReadFileCar {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("transport.txt"))) {

            String line = " ";
            while ((line = br.readLine()) !=null ){
                System.out.println(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }


    }
}