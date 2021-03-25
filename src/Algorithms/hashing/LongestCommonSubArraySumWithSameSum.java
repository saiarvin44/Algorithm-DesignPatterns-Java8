package Algorithms.hashing;

import java.util.HashMap;

public class LongestCommonSubArraySumWithSameSum {
  public static void main(String[] args) {
    int[] arr1 = new int[] {0, 1, 0, 0, 0, 0};
    int[] arr2 = new int[] {1, 0, 1, 0, 0, 1};
    int ans = naive(arr1, arr2);
    int ans2 = optimised(arr1, arr2);
    System.out.println(ans2);
  }

  private static int optimised(int[] arr1, int[] arr2) {
    int[] arr3 = new int[arr1.length];
    for (int i = 0; i < arr1.length; i++) arr3[i] = arr1[i] - arr2[i];
    return maxLenOptimised(arr3, 0);
  }

  private static int maxLenOptimised(int[] arr, int sum) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int preSum = 0, res = 0;
    for (int i = 0; i < arr.length; i++) {
      preSum += arr[i];
      if (preSum == sum) return i + 1;
      if (!map.containsKey(preSum)) map.put(preSum, i);
      if (map.containsKey(preSum - sum)) res = Math.max(res, i - map.get(preSum - sum));
    }
    return res;
  }

  private static int naive(int[] arr1, int[] arr2) {
    int res = 0;
    for (int i = 0; i < arr1.length; i++) {
      int sum1 = 0, sum2 = 0;
      for (int j = i; j < arr1.length; j++) {
        sum1 += arr1[j];
        sum2 += arr2[j];
        if (sum1 == sum2) res = Math.max(res, j - i + 1);
      }
    }
    return res;
  }
}
