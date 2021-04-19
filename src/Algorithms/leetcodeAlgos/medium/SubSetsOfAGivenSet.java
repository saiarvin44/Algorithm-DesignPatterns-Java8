package Algorithms.leetcodeAlgos.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubSetsOfAGivenSet {
  public static void main(String[] args) {
    int[] list = new int[] {1, 2, 3};
    subsets(list);
  }

  public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    ans.add(new ArrayList<Integer>());
    int n = nums.length;
    Arrays.sort(nums);
    for (int i = 0; i < n; i++) {
      ans.add(Arrays.asList(nums[i]));
      for (int j = 1; j < ans.size(); j++) {
        int size = ans.get(j).size();
        if (nums[i] > ans.get(j).get(size - 1)) {
          List<Integer> list = new ArrayList<>();
          for (int k = 0; k < size; k++) list.add(ans.get(j).get(k));
          list.add(nums[i]);
          ans.add(list);
        }
      }
    }
    return ans;
  }
}
