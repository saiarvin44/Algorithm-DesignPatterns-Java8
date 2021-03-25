package Algorithms.searching;

public class PairWithGivenSum {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 8, 12, 30};
        boolean isPresent = twoPointerApproach(arr, arr.length, 18);
        System.out.println(isPresent);
    }

    private static boolean twoPointerApproach(int[] arr, int n, int sum) {
        int left = 0, right = n - 1;
        while (left <= right) {
            if (arr[left] + arr[right] == sum)
                return true;
            else if (arr[left] + arr[right] > sum)
                right--;
            else
                left++;
        }
        return false;
    }
}
