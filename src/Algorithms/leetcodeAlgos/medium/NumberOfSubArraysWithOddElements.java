package Algorithms.leetcodeAlgos.medium;

import java.util.ArrayList;
import java.util.List;

public class NumberOfSubArraysWithOddElements {
  public static List<List<Integer>> subarrays = new ArrayList<>();

  static void findSubArrays(int[] arr, int start, int end) {
    if (end == arr.length) return;
    else if (start > end) findSubArrays(arr, 0, end + 1);
    else {
      List<Integer> temp = new ArrayList<>();
      for (int i = start; i <= end; i++) {
        temp.add(arr[i]);
      }
      if (temp.size() != 0) subarrays.add(temp);
      findSubArrays(arr, start + 1, end);
    }
    return;
  }

  public static void main(String[] args) {
    int[] arr = new int[] {1, 1, 2, 1, 1};
    int k = 3;
    System.out.print(numberOfSubArrays(arr, k));
  }

  public static int numberOfSubArrays(int[] nums, int k) {
    int ans = 0;
    findSubArrays(nums, 0, 0);
    int count;
    for (List<Integer> list : subarrays) {
      count = 0;
      for (Integer elt : list) {
        if (elt % 2 == 1) count++;
      }
      if (count == k) ans++;
    }
    return ans;
  }
}
