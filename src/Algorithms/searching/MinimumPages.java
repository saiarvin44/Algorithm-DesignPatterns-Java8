package Algorithms.searching;

public class MinimumPages {
    public static void main(String[] args) {

    }

    int minPages(int[] arr, int n, int k) {
        if (k == 1)
            return sum(arr, 0, n - 1);
        if (n == 1)
            return arr[0];
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++)
            res = Math.min(res, Math.max(sum(arr, i, n - 1), minPages(arr, i, k - 1)));
        return res;
    }

    int minPagesOptimised(int[] arr, int n, int k) {
        int sum = 0, max = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            max = Math.max(sum, max);
        }
        int low = max, high = sum, res = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isFeasible(arr, n, k, mid)) {
                res = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        return res;
    }

    private boolean isFeasible(int[] arr, int n, int k, int ans) {
        int req = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + arr[i] > ans) {
                req++;
                sum = arr[i];
            } else sum += arr[i];
        }
        return (req <= k);
    }

    private int sum(int[] arr, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++)
            sum += arr[i];
        return sum;
    }
}
