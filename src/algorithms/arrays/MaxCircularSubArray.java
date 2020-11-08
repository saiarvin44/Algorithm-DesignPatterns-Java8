package algorithms.arrays;

public class MaxCircularSubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{5, -2, 3, 4};
        int max = maxCircularSubArray1(arr, arr.length);
        int maxAgain = maxCircularSubArray2(arr, arr.length);
        System.out.println(maxAgain);
    }

    // Kadane's algo to find max in normal subarray
    private static int normalMaxSum(int[] arr, int length) {
        int res = arr[0];
        int maxSum = arr[0];
        for (int i = 1; i < length; i++) {
            maxSum = Math.max(maxSum + arr[i], arr[i]);
            res = Math.max(res, maxSum);
        }
        return res;
    }

    private static int maxCircularSubArray2(int[] arr, int length) {
        int normalSum = normalMaxSum(arr, length);
        int circularSum = 0;
        if (normalSum < 0)
            return normalSum;
        int arrSum = 0;
        for (int i = 0; i < length; i++) {
            arrSum += arr[i];
            arr[i] = -arr[i];
        }
        circularSum = arrSum + normalMaxSum(arr, length);  // adding because we're negating the
        return Math.max(circularSum,normalSum);            // elements
    }

    private static int maxCircularSubArray1(int[] arr, int length) {
        int res = arr[0];
        for (int i = 0; i < length; i++) {
            int currSum = arr[i];
            int currMax = arr[i];
            for (int j = 1; j < length; j++) {
                int index = (i + j) % length;
                currSum += arr[index];
                currMax = Math.max(currSum, currMax);
            }
            res = Math.max(res, currMax);
        }
        return res;
    }
}
