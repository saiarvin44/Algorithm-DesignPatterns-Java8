package Algorithms.DP;

// minimum number of dropping trials to find out threshold floor considering all floors as threshold
// floors
public class EggDroppingPuzzle {
  public static void main(String[] args) {
    int e = 2, f = 10;
    int ans = eggDrop(e, f);
    System.out.print(ans);
  }

  static int eggDrop(int n, int k) {
    if (k == 1 || k == 0) return k;

    if (n == 1) return k;

    int min = Integer.MAX_VALUE;
    int x, res;

    for (x = 1; x <= k; x++) {
      res = Math.max(eggDrop(n - 1, x - 1), eggDrop(n, k - x));
      if (res < min) min = res;
    }

    return min + 1;
  }

  static int eggDropDP(int e, int f) {
    int[][] dp = new int[f + 1][e + 1];
    for (int i = 0; i < f + 1; i++) dp[1][i] = i;
    for (int i = 1; i < e + 1; i++) {
      dp[0][i] = 0;
      dp[1][i] = 1;
    }
    for (int i = 2; i <= f; i++)
      for (int j = 2; j <= e; j++) {
        dp[i][j] = Integer.MAX_VALUE;
        for (int x = 1; x <= i; x++)
          dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[x - 1][j - 1], dp[i - x][j]));
      }
    return dp[f][e];
  }
}
