package algorithms.arrays;

public class RainWaterTapping {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 0, 1, 2, 5};
        int maxWater = getWaterSolution1(arr, arr.length);
        int maxWaterAgain = getWaterSolution2(arr, arr.length);
        System.out.println(maxWaterAgain);
    }

    private static int getWaterSolution2(int[] arr, int length) {
        int res = 0;
        int[] lmax = new int[length];
        int[] rmax = new int[length];
        lmax[0] = arr[0];
        for (int i = 1; i < length; i++)
            lmax[i] = Math.max(arr[i], lmax[i - 1]);
        rmax[length - 1] = arr[length - 1];
        for (int j = length - 2; j >= 0; j--)
            rmax[j] = Math.max(arr[j], rmax[j + 1]);
        for (int i = 1; i < length - 1; i++)
            res = res + (Math.min(lmax[i], rmax[i])) - arr[i];
        return res;
    }

    private static int getWaterSolution1(int[] arr, int length) {
        int res = 0;
        int rmax = 0;
        int lmax = 0;
        for (int i = 1; i < length - 1; i++) {
            rmax = arr[i];
            lmax = arr[i];
            for (int j = 0; j < i; j++)
                lmax = Math.max(lmax, arr[j]);
            for (int j = i + 1; j < length; j++)
                rmax = Math.max(rmax, arr[j]);
            res = res + Math.min(lmax, rmax) - arr[i];
        }
        return res;
    }
}
