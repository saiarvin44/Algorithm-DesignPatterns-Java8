package Algorithms.hashing;

import java.util.HashSet;
import java.util.Set;

// Conitguous elements
public class SubarrayWithZeroSum {
  public static void main(String[] args) {
    int[] arr = new int[] {-3, 4, -3, -1, 1};
    boolean ans = subArrayWithZeroSum(arr);
  }

  private static boolean subArrayWithZeroSum(int[] arr) {
    Set<Integer> set = new HashSet<>();
    int preSum = 0;
    for (int i = 0; i < arr.length; i++) {
      preSum += arr[i];
      if (set.contains(preSum)) return true;
      if (preSum == 0) return true;
      set.add(preSum);
    }
    return false;
  }
}
