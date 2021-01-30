package CoreJava.collections.leetcodeAlgos;

public class RepeatedSubStringPattern {
  public static void main(String[] args) {
    System.out.println(repeatedSubstringPattern("abcabcabcabc"));
  }

  public static boolean repeatedSubstringPattern(String s) {
    if (s.length() > 1 && s.matches("((.)\2+)+")) return true;
    for (int i = 1; i < s.length(); i++) {
      if (s.endsWith(s.substring(0, i))) return true;
    }
    return false;
  }
}
