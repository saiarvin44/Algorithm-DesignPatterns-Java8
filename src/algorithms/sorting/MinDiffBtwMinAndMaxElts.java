package algorithms.sorting;

import java.util.Arrays;

public class MinDiffBtwMinAndMaxElts {
  public static void main(String[] args) {
    // Minimum difference between max and min in a set of m elts in and array of size n :
    int[] arr = new int[] {7, 3, 2, 4, 9, 12, 56};
    System.out.print(minDiff(arr, arr.length, 3));
  }

  private static int minDiff(int[] arr, int n, int m) {
    if (m > n) return -1;
    Arrays.sort(arr);
    int res = arr[m - 1] - arr[0];
    for (int i = 1; i + m - 1 < n; i++) res = Math.min(res, arr[i + m - 1] - arr[i]);
    return res;
  }
}
