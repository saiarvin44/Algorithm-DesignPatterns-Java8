package Algorithms.DP;

public class CountBSTsWithNKeys {
  public static void main(String[] args) {
    int n = 5;
    count(n);
  }

  // res(n) = res(0)*res(n-1) + res(1)*res(n-2) + ... res(n-1)*res(0)
  private static int count(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    for (int i = 1; i <= n; i++) {
      dp[i] = 0;
      for (int j = 0; j < i; j++) dp[i] += dp[j] * dp[i - j - 1];
    }
    return dp[n];
  }
}
