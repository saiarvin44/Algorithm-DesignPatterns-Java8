package Algorithms.arrays;

public class MaxSubArray {
    int[] arr = new int[]{1, -2, 3, -1, 2};
    int sum = maxSumMethod1(arr, arr.length);
    int sumAgain = maxSumMethod2(arr, arr.length);

    private int maxSumMethod2(int[] arr, int length) {
        int maxEnding = arr[0];
        int res = arr[0];
        for (int i = 0; i < length; i++) {
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            res = Math.max(res, maxEnding);
        }
        return res;
    }

    private int maxSumMethod1(int[] arr, int length) {
        int max = arr[0];
        for (int i = 0; i < length; i++) {
            int curr = 0;
            for (int j = i; j < length; j++) {
                curr = curr + arr[j];
                max = Math.max(max, curr);
            }
        }
        return max;
    }
}
