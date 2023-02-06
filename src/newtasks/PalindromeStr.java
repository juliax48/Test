package newtasks;

public class PalindromeStr {
    public static void main(String[] args) {
        PalindromeStr palindromeStr = new PalindromeStr();
        String[] str = {"abc", "acd", "ada"};
        String result = palindromeStr.firstPalindrome(str);
        System.out.println(result);
    }

    public static String firstPalindrome(String[] words) {
        for (String w : words) {
            if (isPalindrome(w)) {
                return w;
            }
        }
        return "";
    }

    private static boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        String reverse = stringBuilder.reverse().toString();
        return s.equals(reverse);
    }
}
