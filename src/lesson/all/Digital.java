package lesson.all;

public class Digital {
    public static void main(String[] args) {
        int[] digitals = {10,10,12};
        int count = 0;
        for (int i = 0; i< digitals.length; i++){
            count += (digitals[i]/10)+(digitals[i]%10);
            System.out.println("i = " + i);
        }
        System.out.println("count = " + count);
    }

    
}
