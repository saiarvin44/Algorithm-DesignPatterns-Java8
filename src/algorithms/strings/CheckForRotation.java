package algorithms.strings;

public class CheckForRotation {
  public static void main(String[] args) {
    String s1 = "ABCD", s2 = "CDAB";
    System.out.println(strRotations(s1, s2));
  }

  private static boolean strRotations(String s1, String s2) {
    if (s1.length() != s2.length()) return false;
    return ((s1 + s1).indexOf(s2) >= 0);
  }
}
