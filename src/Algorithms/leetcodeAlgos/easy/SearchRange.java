package Algorithms.leetcodeAlgos.easy;

public class SearchRange {
  public static void main(String[] args) {
    int[] ans = searchRange(new int[] {1, 4}, 4);
    System.out.println(ans[0] + ":" + ans[1]);
  }

  public static int[] searchRange(int[] nums, int target) {
    boolean found = false, secondFound = false;
    int[] ans = new int[] {-1, -1};
    int n = nums.length;
    if (nums.length == 0) return ans;
    if (n == 1) {
      if (nums[0] == target) return new int[] {0, 0};
      else return new int[] {-1, -1};
    }
    for (int i = 0; i < n - 1; i++) {
      if (nums[i] == target) {
        if (ans[0] == -1) ans[0] = i;
        found = true;
        if (nums[i + 1] == target) {
          ans[1] = i + 1;
          secondFound = true;
          found = true;
        }
      }
    }
    if (!secondFound) ans[1] = ans[0];
    if (!found) {
      if (nums[n - 1] == target) {
        ans[0] = n - 1;
        ans[1] = n - 1;
      }
    }
    return ans;
  }
}
