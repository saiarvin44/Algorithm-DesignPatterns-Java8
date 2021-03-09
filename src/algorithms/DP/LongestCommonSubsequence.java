package algorithms.DP;

import java.util.Arrays;

public class LongestCommonSubsequence {
  static int[][] memo;
  static int[][] dp;

  public static void main(String[] args) {
    String s1 = "AXYZ";
    String s2 = "BAZ";
    memo = new int[s1.length() + 1][s2.length() + 1];
    for (int[] i : memo) Arrays.fill(i, -1);
    int ans = lcs(s1, s2, s1.length(), s2.length());
    int ansTabulation = lcsTabulation(s1, s2, s1.length(), s2.length());
    System.out.print(ansTabulation);
  }

  static int lcs(String s1, String s2, int n, int m) {
    if (memo[n][m] != -1) return memo[n][m];
    if (n == 0 || m == 0) memo[n][m] = 0;
    else {
      if (s1.charAt(n - 1) == s2.charAt(m - 1)) memo[n][m] = 1 + lcs(s1, s2, n - 1, m - 1);
      else memo[n][m] = Math.max(lcs(s1, s2, n - 1, m), lcs(s1, s2, n, m - 1));
    }
    return memo[n][m];
  }

  static int lcsTabulation(String s1, String s2, int n, int m) {
    dp = new int[n + 1][m + 1];
    for (int i = 0; i < n + 1; i++) Arrays.fill(dp[i], 0);
    for (int i = 1; i <= n; i++)
      for (int j = 1; j <= m; j++)
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
        else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
    return dp[n][m];
  }
}
