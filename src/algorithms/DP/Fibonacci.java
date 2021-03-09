package algorithms.DP;

import java.util.Arrays;

public class Fibonacci {
  public static void main(String[] args) {
    int n = 6;
    int[] memo = new int[n + 1];
    Arrays.fill(memo, -1);
    int ans = fibonacciMemoization(n, memo);
    System.out.print(ans);
  }

  public static int fibonacciMemoization(int n, int[] memo) {
    if (memo[n] == -1) {
      int res;
      if (n == 0 || n == 1) res = n;
      else res = fibonacciMemoization(n - 1, memo) + fibonacciMemoization(n - 2, memo);
      memo[n] = res;
    }
    return memo[n];
  }

  public static int fibonacciTabular(int n) {
    int[] f = new int[n + 1];
    f[0] = 0;
    f[1] = 1;
    for (int i = 2; i <= n; i++) f[i] = f[i - 1] + f[i - 2];
    return f[n];
  }
}
