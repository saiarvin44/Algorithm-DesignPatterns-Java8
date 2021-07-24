package Algorithms.leetcodeAlgos.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ArithmaticSubArrays {
    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int lSize = l.length;
        int rSize = r.length;
        int n = nums.length;
        List<Boolean> ans = new ArrayList<>();
        Boolean res;
        for (int i = 0; i < lSize; i++) {
            int[] slice = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(slice);
            int d = slice[1] - slice[0];
            res = true;
            for (int j = 2; j < slice.length; j++) {
                if (slice[j] - slice[j - 1] != d) {
                    res = false;
                    break;
                }
            }
            ans.add(res);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 5, 9, 3, 7};
        int[] l = new int[]{0, 0, 2};
        int[] r = new int[]{2, 3, 5};
        checkArithmeticSubarrays(nums, l, r);
    }
}