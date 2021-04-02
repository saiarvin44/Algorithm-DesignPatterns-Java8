package Algorithms.DP;

public class Knapsack01 {
  public static void main(String[] args) {
    int[] v = new int[] {10, 40, 30, 50};
    int[] w = new int[] {5, 4, 6, 3};
    int W = 10;
    System.out.print(knapsack(v, w, W, w.length));
  }

  private static int knapsack(int[] v, int[] w, int W, int n) {
    if (n == 0 || W == 0) return 0;
    if (w[n - 1] > W) return knapsack(v, w, W, n - 1);
    else return Math.max(knapsack(v, w, W, n - 1), v[n - 1] + knapsack(v, w, W - w[n - 1], n - 1));
  }

  private static int knapsackDP(int[] v, int[] w, int W, int n) {
    int dp[][] = new int[n + 1][W + 1];
    for (int i = 0; i < n + 1; i++) dp[i][0] = 0;
    for (int i = 0; i < W + 1; i++) dp[0][i] = 0;

    for (int i = 1; i <= n; i++)
      for (int j = 1; j <= W; j++)
        if (w[i - 1] > j) dp[i][j] = dp[i - 1][j];
        else dp[i][j] = Math.max(v[i - 1] + dp[i - 1][j - w[i - 1]], dp[i - 1][j]);
    return dp[n][W];
  }
}
