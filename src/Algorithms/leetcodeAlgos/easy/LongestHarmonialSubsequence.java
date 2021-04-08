package Algorithms.leetcodeAlgos.easy;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class LongestHarmonialSubsequence {
  public static void main(String[] args) {
    System.out.print(
        findLHS(
            new int[] {
              1, 3, 1, 3, 2, 3, 0, 3, 0, 1, 2, 2, 2, -1, 2, 1, 0, 0, 2, 2, 3, -3, 1, 2, 2, 0, 1, 3,
              1
            }));
  }

  public static int findLHS(int[] nums) {
    Map<Integer, Integer> map = new TreeMap<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
      else map.put(nums[i], 1);
    }
    int[] key = new int[map.size()];
    int i = 0, j = 0;
    int[] value = new int[map.size()];
    for (Integer e : map.keySet()) key[i++] = e;
    for (Integer e : map.values()) value[j++] = e;
    int res = 0;
    for (i = 0; i < key.length - 1; i++)
      if (Math.abs(key[i] - key[i + 1]) == 1) res = Math.max(res, value[i] + value[i + 1]);
    return res;
  }
}
