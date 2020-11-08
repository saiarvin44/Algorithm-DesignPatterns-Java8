package algorithms.arrays;

public class MaxAppearingEltInRangePrefixSum {
    public static void main(String[] args) {
        int[] l = new int[]{1, 2, 5, 15};
        int[] r = new int[]{5, 8, 7, 18};
        int max = maxOcc(l, r, l.length);
        System.out.println(max);
    }

    private static int maxOcc(int[] l, int[] r, int n) {
        int[] binaryArr = new int[1000];
        for (int i = 0; i < 1000; i++)
            binaryArr[i] = 0;
        for (int i = 0; i < n; i++) {
            binaryArr[l[i]]++;
            binaryArr[r[i] + 1]--;
        }
        int max = binaryArr[0];
        int res = 0;
        for (int i = 1; i < 1000; i++) {
            binaryArr[i] += binaryArr[i - 1];
            if (max < binaryArr[i]) {
                max = binaryArr[i];
                res = i;
            }
        }
        return res;
    }
}
