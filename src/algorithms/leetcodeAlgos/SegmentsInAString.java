package algorithms.leetcodeAlgos;

public class SegmentsInAString {
  public static void main(String[] args) {
    String s = "    foo    bar";
    System.out.print(noOfSegments(s));
  }

  private static int noOfSegments(String s) {
    String tmp = s.trim();
    if (tmp.length() == 0) return 0;
    int count = 1;
    if (s.charAt(0) == ' ') count = 0;
    boolean loopEntered;
    if (s.equals("")) return 0;
    for (int i = 0; i < s.length(); i++) {
      loopEntered = false;
      while (i < s.length() && s.charAt(i) == ' ') {
        i++;
        loopEntered = true;
      }
      if (loopEntered && i != s.length()) count++;
    }
    return count;
  }
}
