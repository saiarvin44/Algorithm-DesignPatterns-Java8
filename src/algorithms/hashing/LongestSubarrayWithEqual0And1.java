package algorithms.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithEqual0And1 {
  public static void main(String[] args) {
    int[] arr = new int[] {1, 0, 1, 1, 1, 0, 0};
    int ans = longestSub(arr);
    System.out.print(ans);
  }

  private static int longestSub(int[] arr) {
    int res = 0;
    for (int i = 0; i < arr.length; i++) {
      int c0 = 0, c1 = 0;
      for (int j = i; j < arr.length; j++) {
        if (arr[j] == 0) c0++;
        else c1++;
        if (c0 == c1) res = Math.max(res, j - i + 1);
      }
    }
    return res;
  }

  private static int longestSubOptimised(int[] arr) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
      if(entry.getValue()==0)
        entry.setValue(-1);
    }
    int preSum = 0, res = 0;
    for (int i = 0; i < arr.length; i++) {
      preSum += arr[i];
      if (arr[i] == 0 && res == 0) res = 1;
      if (preSum == 0) res = i + 1;
      Integer prev_i = map.get(preSum);
      if (prev_i != null) res = Math.max(res, i - prev_i + 1);
      else map.put(preSum, i);
    }
    return res;
  }
}
