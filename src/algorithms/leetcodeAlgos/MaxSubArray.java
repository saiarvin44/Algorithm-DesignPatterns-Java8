package algorithms.leetcodeAlgos;

public class MaxSubArray {
  public static void main(String[] args) {
    System.out.println(maxSubArray(new int[] {1, 2}));
  }

  public static int maxSubArray(int[] nums) {
    if (nums.length == 1) return nums[0];
    int maxEnding = nums[0];
    int res = nums[0];
    for (int i = 1; i < nums.length; i++) {
      maxEnding = Math.max(maxEnding + nums[i], nums[i]);
      res = Math.max(res, maxEnding);
    }
    return res;
  }
}
