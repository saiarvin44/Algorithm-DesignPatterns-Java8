package Algorithms.Greedy;

class MinOperationsToMakeArrayIncremental {
    public static int minOperations(int[] nums) {
        int i = 1;
        int prev = nums[0];
        int curr = nums[1];
        int count = 0;
        while (i < nums.length) {
            while (nums[i] <= prev) {
                nums[i]++;
                curr++;
                count++;
            }
            i++;
            prev = curr;
            if (i >= nums.length) break;
            curr = nums[i];
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1, 1, 1}));
    }
}