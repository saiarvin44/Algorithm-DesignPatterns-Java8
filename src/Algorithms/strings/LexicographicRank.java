package Algorithms.strings;

public class LexicographicRank {
  public static void main(String[] args) {
    String s = "string";
    int ans = rank(s);
    System.out.println(ans);
  }

  private static int rank(String s) {
    int res = 1;
    int n = s.length();
    int mul = fact(n);

    // to get count of smaller characters in the right
    int[] count = new int[256];
    for (int i = 0; i < n; i++) count[s.charAt(i)]++;
    for (int i = 1; i < 256; i++) count[i] += count[i - 1];
    for (int i = 0; i < n - 1; i++) {
      mul = mul / (n - i);
      res = res + (count[s.charAt(i) - 1] * mul);
      for (int j = s.charAt(i); j < 256; j++) count[j]--;
    }
    return res;
  }

  private static int fact(int n) {
    int ans = 1;
    for (int i = 1; i <= n; i++) ans *= i;
    return ans;
  }
}
