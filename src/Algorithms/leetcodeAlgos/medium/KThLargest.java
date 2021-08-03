package Algorithms.leetcodeAlgos.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class KThLargest {
    public static int findKthLargest(int[] nums, int k) {
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());

        return arr[k - 1];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(arr, 2));
    }
}