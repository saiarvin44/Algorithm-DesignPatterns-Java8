package algorithms.strings;

public class LongestProperPrefixSuffix {
  public static void main(String[] args) {
    String s = "ababacab";
    int[] lps = new int[s.length()];
    fillLPS(s, lps);
  }

  private static int longPropPreSuff(String s, int n) {
    for (int len = n - 1; len > 0; len--) {
      boolean flag = true;
      for (int i = 0; i < len; i++) if (s.charAt(i) != s.charAt(n - len + i)) flag = false;
      if (flag == true) return len;
    }
    return 0;
  }

  private static void fillLPS(String s, int[] lps) {
    for (int i = 0; i < s.length(); i++) lps[i] = longPropPreSuff(s, i + 1);
    for (int i = 0; i < s.length(); i++) System.out.print(lps[i]);
  }
}
