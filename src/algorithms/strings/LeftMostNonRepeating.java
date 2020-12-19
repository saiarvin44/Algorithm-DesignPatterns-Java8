package algorithms.strings;

import java.util.Arrays;

public class LeftMostNonRepeating {
  public static void main(String[] args) {
    String str = "abbcda";
    int pos = leftNonRepeating(str);
    int pos2 = leftNonRepeatingOptimized(str);
    System.out.println(pos2);
  }

  private static int leftNonRepeatingOptimized(String str) {
    int[] fi = new int[256];
    Arrays.fill(fi, -1);
    for (int i = 0; i < str.length(); i++) {
      if (fi[str.charAt(i)] == -1) fi[str.charAt(i)] = i;
      else fi[str.charAt(i)] = -2;
    }
    int res = Integer.MAX_VALUE;
    for (int i = 0; i < 256; i++) if (fi[i] >= 0) res = Math.min(res, fi[i]);
    return (res == Integer.MAX_VALUE) ? -1 : res;
  }

  private static int leftNonRepeating(String str) {
    int[] count = new int[256];
    for (int i = 0; i < str.length(); i++) count[str.charAt(i)]++;
    for (int i = 0; i < str.length(); i++) if (count[str.charAt(i)] == 1) return i;
    return -1;
  }
}
