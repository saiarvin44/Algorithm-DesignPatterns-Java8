package Algorithms.leetcodeAlgos;

import java.util.Arrays;

public class ThreeSumClosest {
  public static void main(String[] args) {
    int[] arr = new int[] {1, 2, 4, 8, 16, 32, 64, 128};
    int target = 82;
    System.out.println("3Sum closest : " + threeSumClosest(arr, target));
  }

  public static int threeSumClosest(int[] nums, int target) {
    int res;
    int n = nums.length;
    Arrays.sort(nums);
    res = nums[n - 1] + nums[n - 2] + nums[n - 3];
    for (int i = 0; i < n - 2; i++) {
      int j = i + 1;
      int k = n - 1;
      while (j < k) {
        int temp = nums[i] + nums[j] + nums[k];
        if ((Math.abs((temp - target)) < Math.abs((res - target)))) res = temp;
        if (temp < target) j++;
        else k--;
      }
    }
    return res;
  }
}
