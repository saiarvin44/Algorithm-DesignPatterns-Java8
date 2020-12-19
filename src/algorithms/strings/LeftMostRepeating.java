package algorithms.strings;

import java.util.Arrays;

public class LeftMostRepeating {
  public static void main(String[] args) {
    String s1 = "abcc";
    int res = leftMost(s1);
    int res2 = leftMostOptimized(s1);
    System.out.println(res2);
  }

  private static int leftMostOptimized(String s) {
    int[] fIndex = new int[256];
    Arrays.fill(fIndex, -1);
    int res = Integer.MAX_VALUE;
    for (int i = 0; i < s.length(); i++) {
      int fi = fIndex[s.charAt(i)];
      if (fi == -1) fIndex[s.charAt(i)] = i;
      else res = Math.min(res, fi);
    }
    return res == Integer.MAX_VALUE ? -1 : res;
  }

  private static int leftMost(String s1) {
    int[] count = new int[256];
    for (int i = 0; i < s1.length(); i++) count[s1.charAt(i)]++;
    for (int i = 0; i < s1.length(); i++) if (count[s1.charAt(i)] > 1) return i;
    return -1;
  }
}
