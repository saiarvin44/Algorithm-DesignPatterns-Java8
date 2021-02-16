package algorithms.leetcodeAlgos;

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {
  public static void main(String[] args) {
    System.out.println(threeSum(new int[] {-1, 2, 1, -4}));
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    int n = nums.length;
    List<Integer> sub = null;
    for (int i = 0; i < n - 2; i++) {
      for (int j = i + 1; j < n - 1; j++) {
        for (int k = j + 1; k < n; k++)
          if (nums[i] + nums[j] + nums[k] == 0) {
            sub = new ArrayList<>();
            sub.add(nums[i]);
            sub.add(nums[j]);
            sub.add(nums[k]);
            ans.add(sub);
          }
      }
    }
    return ans;
  }
}
