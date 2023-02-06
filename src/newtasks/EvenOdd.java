package newtasks;

import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer number = scanner.nextInt();
        if(number>0 || number<10){
            System.out.println(number + "form 0 to 10");
        } else {
            System.out.println(" is not form 0 to 10");
        }

        char x = 'h';
        for (int i = 0; i<11; i++){

            System.out.println(x+i);
        }

    }


}

