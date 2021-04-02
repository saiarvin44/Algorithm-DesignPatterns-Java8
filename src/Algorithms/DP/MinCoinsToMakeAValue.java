package Algorithms.DP;

public class MinCoinsToMakeAValue {
  public static void main(String[] args) {
    int[] coins = new int[] {25, 10, 5};
    int val = 30;
    getMin(coins, coins.length, val);
  }

  private static int getMin(int[] coins, int n, int val) {
    if (val == 0) return 0;
    int res = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++)
      if (coins[i] <= val) {
        int sub_res = getMin(coins, n, val - coins[i]);
        if (sub_res != Integer.MAX_VALUE) res = Math.min(res, sub_res + 1);
      }
    return res;
  }
}
