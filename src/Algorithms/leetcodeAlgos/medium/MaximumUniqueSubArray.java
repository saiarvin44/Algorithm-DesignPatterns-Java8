package Algorithms.leetcodeAlgos.medium;

import java.util.HashMap;
import java.util.Map;

class MaximumUniqueSubArray {
  public static void main(String[] args) {
    int[] arr = new int[] {4, 2, 4, 5, 6};
    System.out.print(maximumUniqueSubArray(arr));
  }

  public static int maximumUniqueSubArray(int[] nums) {
    int start = 0, end = 0;
    Map<Integer, Integer> map = new HashMap<>();
    int sum = 0;
    int max = Integer.MIN_VALUE;
    while (end < nums.length) {
      sum += nums[end];
      map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
      if (end - start + 1 == map.size()) max = Math.max(max, sum);
      else if (end - start + 1 > map.size()) {
        while (end - start + 1 > map.size()) {
          sum = sum - nums[start];
          if (map.containsKey(nums[start])) {
            int freq = map.get(nums[start]);
            freq--;
            if (freq == 0) map.remove(nums[start]);
            else map.put(nums[start], freq);
          }
          start++;
        }
      }
      end++;
    }
    return max;
  }
}
