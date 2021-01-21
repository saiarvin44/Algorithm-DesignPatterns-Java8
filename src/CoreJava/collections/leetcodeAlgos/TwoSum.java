package CoreJava.collections.leetcodeAlgos;

import java.util.Arrays;

public class TwoSum {
  public static void main(String[] args) {
    int[] ans2 = twoSum(new int[] {3, 2, 3}, 6);

    System.out.println(ans2[0] + ":" + ans2[1]);
  }

  public static int[] twoSum(int[] nums, int target) {
    int n = nums.length;
    int[] temp = new int[n];
    for (int i = 0; i < n; i++) temp[i] = nums[i];
    Arrays.sort(nums);
    int sum;
    int[] ans = new int[2];
    int l = 0, r = n - 1;
    while (l < r) {
      sum = nums[l] + nums[r];
      if (sum == target) {
        if (nums[l] == nums[r]) {
          for (int i = 0; i < n; i++)
            if (temp[i] == nums[l]) {
              ans[0] = i;
              break;
            }
          temp[ans[0]] = -1;
          for (int i = 0; i < n; i++)
            if (temp[i] == nums[l]) {
              ans[1] = i;
              break;
            }
          return ans;
        } else {
          for (int i = 0; i < n; i++)
            if (temp[i] == nums[l]) {
              ans[0] = i;
              break;
            }
          for (int i = 0; i < n; i++)
            if (temp[i] == nums[r]) {
              ans[1] = i;
              break;
            }
          return ans;
        }
      } else if (sum > target) r--;
      else if (sum < target) l++;
    }
    return null;
  }
}
