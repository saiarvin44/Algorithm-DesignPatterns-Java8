package Algorithms.leetcodeAlgos.curatedAlgos;

import java.util.Arrays;

public class ChocolateDistribution {
  public static void main(String[] args) {
    int[] arr = new int[] {7, 3, 2, 4, 9, 12, 56};
    int m = 3;
    System.out.print(distributeChocolates(arr, m));
  }

  private static int distributeChocolates(int[] arr, int m) {
    Arrays.sort(arr);
    int min = Integer.MAX_VALUE;
    for (int i = 0; i <= arr.length - m; i++) min = Math.min(min, arr[i + m - 1] - arr[i]);
    return min;
  }
}
