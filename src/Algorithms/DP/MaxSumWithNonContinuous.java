package Algorithms.DP;

public class MaxSumWithNonContinuous {
  public static void main(String[] args) {
    int[] arr = new int[] {10, 5, 15, 20,18};
    int n = 5;
    int ans = maxSumDp(arr, n);
    System.out.print(ans);
  }

  private static int maxSum(int[] arr, int n) {
    if (n == 1) return arr[0];
    else if (n == 2) return Math.max(arr[0], arr[1]);
    else return Math.max(maxSum(arr, n - 1), maxSum(arr, n - 2) + arr[n - 1]);
  }

  private static int maxSumDp(int[] arr, int n) {
    int dp[] = new int[n + 1];
    dp[0] = 0;
    dp[1] = arr[0];
    dp[2] = Math.max(arr[0], arr[1]);
    for (int i = 3; i <= n; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i - 1]);
    }
    return dp[n];
  }
}
