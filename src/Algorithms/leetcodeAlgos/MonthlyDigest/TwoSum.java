package Algorithms.leetcodeAlgos.MonthlyDigest;

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        boolean found = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        return ans;
    }

    public static void main(String[] args) {
        twoSum(new int[]{3, 2, 4}, 6);
    }
}