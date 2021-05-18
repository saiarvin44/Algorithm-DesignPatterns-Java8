package Algorithms.DP;

public class NumberOfSubsetsWithGivenSum {
  public static void main(String[] args) {
    int[] arr = new int[] {10, 15, 20};
    System.out.print(subsets(arr, arr.length, 25));
  }

  private static int subsets(int[] arr, int n, int sum) {
    if (n == 0) return sum == 0 ? 1 : 0;
    return subsets(arr, n - 1, sum) + subsets(arr, n - 1, sum - arr[n - 1]);
  }

  private static int subsetsDP(int[] arr, int n, int sum) {
    int[][] dp = new int[n + 1][sum + 1];
    for (int i = 0; i <= n; i++) dp[i][0] = 1;
    for (int i = 0; i <= sum; i++) dp[0][i] = 0;
    for (int i = 1; i <= n; i++)
      for (int j = 1; j <= sum; j++) {
        if (j < arr[i - 1]) dp[i][j] = dp[i - 1][j];
        else dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i - 1]];
      }
    return dp[n][sum];
  }
}
