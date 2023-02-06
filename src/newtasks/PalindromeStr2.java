package newtasks;

public class PalindromeStr2 {
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

    public static boolean isPalindrome(String s) {
        for (int index = 0; index < s.length() / 2; index++) {
            if (s.charAt(index) != s.charAt(s.length()) - 1 - index) {
                return false;
            }
        }
        return true;
    }

}
