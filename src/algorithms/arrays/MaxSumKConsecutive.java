package algorithms.arrays;

public class MaxSumKConsecutive {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 30, -5, 20, 7};
        int k = 3;
        int maxSum = maxSumConsecutive(arr, arr.length, k);
        System.out.println(maxSum);
    }

    private static int maxSumConsecutive(int[] arr, int n, int k) {
        int curr_sum = 0;
        for (int i = 0; i < k; i++)
            curr_sum += arr[i];
        int max_sum = curr_sum;
        for (int i = k; i < n; i++) {
            curr_sum += (arr[i] - arr[i - k]);
            max_sum = Math.max(max_sum, curr_sum);
        }
        return max_sum;
    }
}
