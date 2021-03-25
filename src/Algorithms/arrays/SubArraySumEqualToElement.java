package Algorithms.arrays;

public class SubArraySumEqualToElement {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 20, 3, 10, 5};
        int sum = 33;
        boolean isTrue = isSubSum(arr, sum);
        System.out.println(isTrue);
    }

    private static boolean isSubSum(int[] arr, int sum) {
        int n = arr.length;
        int currSum = arr[0];
        int start = 0, end;
        for (end = 1; end < n; end++) {
            while (currSum > sum && start < end - 1) {
                currSum -= arr[start];
                start++;
            }
            if (currSum == sum)
                return true;
            if (end < n)
                currSum += arr[end];
        }
        return currSum == sum;
    }
}
