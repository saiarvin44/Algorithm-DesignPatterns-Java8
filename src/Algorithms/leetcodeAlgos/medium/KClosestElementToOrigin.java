package Algorithms.leetcodeAlgos.medium;

import java.util.Arrays;
import java.util.Comparator;

class KClosestElementToOrigin {
    public static int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, Comparator.comparingDouble(a -> Math.sqrt((a[0] * a[0]) + (a[1] * a[1]))));

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i][0] = points[i][0];
            ans[i][1] = points[i][1];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {3, 3},
                {5, -1},
                {-2, 4}
        };

        kClosest(arr, 2);

    }
}