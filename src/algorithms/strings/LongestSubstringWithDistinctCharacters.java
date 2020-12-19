package algorithms.strings;

import java.util.Arrays;

public class LongestSubstringWithDistinctCharacters {
  public static void main(String[] args) {
    String s = "abcadbd";
    int ans = naive(s);
    int ans2 = naiveButLittleBetter(s);
    int ans3 = efficient(s);
    System.out.println(ans3);
  }

  private static int efficient(String s) {
    int n = s.length(), res = 0;
    int[] prev = new int[256];
    Arrays.fill(prev, -1);
    int i = 0;
    for (int j = 0; j < n; j++) {
      i = Math.max(i, prev[s.charAt(j)] + 1);
      int maxEnd = j - i + 1;
      res = Math.max(res, maxEnd);
      prev[s.charAt(j)] = j;
    }
    return res;
  }

  private static int naiveButLittleBetter(String s) {
    int n = s.length(), res = 0;
    for (int i = 0; i < n; i++) {
      boolean[] visited = new boolean[256];
      for (int j = i; j < n; j++) {
        if (visited[s.charAt(j)] == true) break;
        else {
          res = Math.max(res, j - i + 1);
          visited[s.charAt(j)] = true;
        }
      }
    }
    return res;
  }

  private static int naive(String s) {
    int n = s.length(), res = 0;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++) if (areDistinct(s, i, j)) res = Math.max(res, j - i + 1);
    return res;
  }

  private static boolean areDistinct(String s, int i, int j) {
    boolean visited[] = new boolean[256];
    for (int k = i; k <= j; k++) {
      if (visited[s.charAt(k)] == true) return false;
      visited[s.charAt(i)] = true;
    }
    return true;
  }
}
