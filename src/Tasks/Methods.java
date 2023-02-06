package Tasks;

public class Methods {
    public static void main(String[] args) {

        String str2 = "Hi, agaaaaain, bob";
        int count = 0;
        char symbol;
        for (int i = 0; i < str2.length(); i++) {
            symbol = str2.charAt(i);
                if (symbol == 'a') {
                count++;
            }

        }
        System.out.println(count + "a");
    }


//
//
//        for(int i = 1; i < 10; i++) {
//            for(int j = 1; j < 10; j++) {
//                System.out.print(i * j + "    ");
//            }
//            System.out.println("");
//        }
//
//        int num = 10;
//        System.out.print(num);
//
//        switch (num) {
//            case 1:
//                if (num == 1) {
//                    System.out.print(" rubl");
//                    break;
//                }
//            case 2:
//                if (num > 1 || num<5) {
//                    System.out.print(" rublia");
//                    break;
//                }
//            case 3:
//                if (num > 5) {
//                    System.out.println(" rublei");
//                }
//                break;
//            default:
//                System.out.println("error");
//        }
//    }
//
//    public static int sumNumbers(int a, int b) {
//        return a + b * 2;
//    }
//

}

