package Algorithms.leetcodeAlgos.easy;

public class ValidPalindromeByDeletingOne {
  public static void main(String[] args) {
    System.out.print(validPalindrome("eedede ededee"));
  }

  public static boolean validPalindrome(String s) {
    int count = 0;
    StringBuilder builder = new StringBuilder();
    builder.append(s);
    builder.reverse();
    String reverse = builder.toString();
    if (reverse.equals(s)) return true;
    char[] reverseChar = reverse.toCharArray();
    char[] normalChar = s.toCharArray();
    for (int i = 0; i < reverseChar.length; i++) if (normalChar[i] != reverseChar[i]) count++;
    if (count == 2) return true;
    return false;
  }
}
