package algorithms.hashing;

import java.util.HashSet;
import java.util.Set;

public class SubrrayWithGivenSum {
  public static void main(String[] args) {
    int[] arr = new int[] {5, 8, 6, 13, 3, -1};
    boolean ans = subArrayWithGivenSum(arr, 22);
    System.out.print(ans);
  }

  private static boolean subArrayWithGivenSum(int[] arr, int sum) {
    Set<Integer> set = new HashSet<>();
    int preSum = 0;
    for (int i = 0; i < arr.length; i++) {
      preSum += arr[i];
      if (preSum == sum) return true;
      if (set.contains(preSum - sum)) return true;
      set.add(preSum);
    }
    return false;
  }
}
