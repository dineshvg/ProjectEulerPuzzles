public class Palindrome {
    public static boolean isPalindrome(String word) {
        return word.toLowerCase().equals(new StringBuilder(word).reverse().toString().toLowerCase());

    }

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
    }
}