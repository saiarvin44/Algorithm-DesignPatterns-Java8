package Algorithms.DP;

public class MaximumSumIncreasingSubsequence {
  public static void main(String[] args) {
    int[] msis = new int[] {3, 20, 4, 6, 7, 30};
    int n = msis.length;
    System.out.print(msis(msis, n));
  }

  private static int msis(int[] arr, int n) {
    int[] msis = new int[n];
    for (int i = 0; i < n; i++) {
      msis[i] = arr[i];
      for (int j = 0; j < i; j++)
        if (arr[j] < arr[i]) msis[i] = Math.max(msis[i], arr[i] + msis[j]);
    }
    int res = msis[0];
    for (int i = 1; i < n; i++) res = Math.max(res, msis[i]);
    return res;
  }
}
