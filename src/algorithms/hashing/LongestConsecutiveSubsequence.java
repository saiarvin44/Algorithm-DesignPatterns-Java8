package algorithms.hashing;

import java.util.Arrays;
import java.util.HashMap;

public class LongestConsecutiveSubsequence {
  public static void main(String[] args) {
    int[] arr = new int[] {1, 9, 3, 4, 2, 10, 13};
    int ans = findLongest(arr);
    int ans2 = findLongestOptimized(arr);
    System.out.println(ans2);
  }

  private static int findLongestOptimized(int[] arr) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int count = 0;
    int res = 0;
    for (int i = 0; i < arr.length; i++) map.put(arr[i], i);
    for (int i = 0; i < arr.length; i++) {
      if (!map.containsKey(arr[i] - 1)) {
        count = 1;
        while (map.containsKey(arr[i] + count)) count++;
        res = Math.max(res, count);
      }
    }
    return res;
  }

  private static int findLongest(int[] arr) {
    Arrays.sort(arr);
    int res = 1, curr = 1;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == arr[i - 1] + 1) curr++;
      else {
        res = Math.max(res, curr);
        curr = 1;
      }
    }
    res = Math.max(res, curr);
    return res;
  }
}
