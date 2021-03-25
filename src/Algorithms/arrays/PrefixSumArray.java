package Algorithms.arrays;

public class PrefixSumArray {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 8, -9, 20, 6};
        boolean isEquilibrium = EquilibriumPoint(arr);
        boolean isEquilibrium2 = EquilibriumPoint2(arr);
        System.out.println(isEquilibrium2);
    }

    private static boolean EquilibriumPoint2(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++)
            sum += arr[i];
        int lsum = 0;
        for (int i = 0; i < n; i++) {
            if (lsum == sum - arr[i])
                return true;
            lsum += arr[i];
            sum -= arr[i];
        }
        return false;
    }

    private static boolean EquilibriumPoint(int[] arr) {
        int n = arr.length;
        int lsum = 0;
        int rsum = 0;
        for (int i = 0; i < n; i++) {
            lsum = 0;
            rsum = 0;
            for (int j = 0; j < i; j++)
                lsum += arr[j];
            for (int k = i + 1; k < n; k++)
                rsum += arr[k];
            if (lsum == rsum)
                return true;
        }
        return false;
    }
}
