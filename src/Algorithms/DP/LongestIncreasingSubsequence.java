package Algorithms.DP;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

  public static void main(String[] args) {
    int[] arr = new int[] {3, 4, 2, 8, 10, 5, 1};
    System.out.println(lis(arr, arr.length));
  }

  private static int lis(int[] arr, int n) {
    int[] lis = new int[n];
    Arrays.fill(lis, 1);
    for (int i = 1; i < n; i++)
      for (int j = 0; j < i; j++) if (arr[j] < arr[i]) lis[i] = Math.max(lis[i], lis[j] + 1);
    int res = lis[0];
    for (int i = 1; i < n; i++) res = Math.max(res, lis[i]);
    return res;
  }
}
