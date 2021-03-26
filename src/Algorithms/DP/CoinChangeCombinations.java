package Algorithms.DP;

import java.util.Arrays;

public class CoinChangeCombinations {

  public static void main(String[] args) {
    int[] coins = new int[] {2, 5, 3, 6};
    int n = coins.length;
    int sum = 10;
    System.out.print(getCountDP(coins, sum, n));
  }

  private static int getCount(int[] coins, int sum, int n) {
    if (sum == 0) return 1;
    if (n == 0) return 0;
    int res = getCount(coins, sum, n - 1);
    if (coins[n - 1] <= sum) res = res + getCount(coins, sum - coins[n - 1], n);
    return res;
  }

  private static int getCountDP(int[] coins, int sum, int n) {
    int[][] dp =
        new int[sum + 1]
            [n + 1]; // dp[i][j] is no of combinations we can get with sum i and coins from i to j
    Arrays.fill(dp[0], 1);
    for (int i = 0; i < sum + 1; i++) dp[i][0] = 0;
    for (int i = 1; i < sum + 1; i++)
      for (int j = 1; j < n + 1; j++) {
        dp[i][j] = dp[i][j - 1];
        if (coins[j - 1] <= i) dp[i][j] += dp[i - coins[j - 1]][j];
      }
    return dp[sum][n];
  }
}
