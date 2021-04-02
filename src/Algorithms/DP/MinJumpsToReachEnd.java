package Algorithms.DP;

public class MinJumpsToReachEnd {
  public static void main(String[] args) {
    int[] arr =
        new int[] {
          3, 4, 2, 1, 2, 1,
        };
    System.out.print(minJumps(arr, arr.length));
  }

  private static int minJumps(int[] arr, int n) {
    int res = Integer.MAX_VALUE;
    if (n == 1) return 0;
    for (int i = 0; i < n - 1; i++) {
      if (i + arr[i] >= n - 1) {
        int tempRes = minJumps(arr, i + 1);
        if (tempRes != Integer.MAX_VALUE) res = Math.min(res, tempRes + 1);
      }
    }
    return res;
  }

  private static int minJumpsDP(int[] arr, int n) {
    int[] dp = new int[n];
    dp[0] = 0;
    for (int i = 1; i < n; i++) dp[i] = Integer.MAX_VALUE;
    for (int i = 1; i < n; i++)
      for (int j = 0; j < i; j++)
        if (j + arr[j] >= i) if (dp[j] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], dp[j] + 1);
    return dp[n - 1];
  }
}
