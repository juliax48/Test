package lesson14.lambdastreamsapi;

public class SwitchLambda {
    public static void main(String[] args) {
        Integer x = 7;

        String result = switch (x) {
            case 1 -> "one";
            case 2 -> "two";
            case 5 -> "five";
            default -> "I do not know";
        };
        System.out.println(result);
    }



}
