package algorithms.hashing;

import java.util.HashMap;

public class LongestSubArrayWithGivenSum {
  public static void main(String[] args) {
    int[] arr = new int[] {5, 8, -4, -4, 9, -2, 2};
    int[] arr2 = new int[] {8, 3, 1, 5, -6, 6, 2, 2};
    int ans = maxlen(arr, 4);
    int ansOptimised = maxLenOptimised(arr2, 4);
    System.out.print(ansOptimised);
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

  private static int maxlen(int[] arr, int sum) {
    int res = 0;
    int len = arr.length;
    for (int i = 0; i < len; i++) {
      int curr_sum = 0;
      for (int j = i; j < len; j++) {
        curr_sum += arr[j];
        if (curr_sum == sum) res = Math.max(res, j - i + 1);
      }
    }
    return res;
  }
}
