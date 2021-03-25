package Algorithms.leetcodeAlgos;

public class DeleteSingleCharacterAndCheckPalindrome {
  public static void main(String[] args) {
    String s = "eedede";
    System.out.print(deleteAndCheckPalindrome(s));
  }

  private static boolean deleteAndCheckPalindrome(String s) {
    String temp;
    StringBuilder builder;
    for (int i = 0; i < s.length(); i++) {
      temp = s.substring(0, i) + s.substring(i + 1);
      builder = new StringBuilder(temp).reverse();
      if (builder.toString().equals(temp)) return true;
    }
    return false;
  }
}
