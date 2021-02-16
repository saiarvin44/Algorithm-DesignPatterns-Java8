package algorithms.leetcodeAlgos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ContainsNearByDuplicate {
  public static void main(String[] args) {
    System.out.println(containsNearbyDuplicate(new int[] {1, 0, 0, 1}, 2));
  }

  public static boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int res = Integer.MAX_VALUE;
    int findPrev;
    for (int i = 0; i < nums.length; i++) {
      findPrev = findIfPresent(map, nums[i]);
      if (findPrev != -1) {
        res = Math.min(res, i - findPrev);
      }
      map.put(i, nums[i]);
    }
    if (res == 0 || res > k) return false;
    return true;
  }

  public static int findIfPresent(Map<Integer, Integer> map, Integer val) {
    List<Integer> key =
        map.entrySet().stream()
            .filter(entry -> (val == entry.getValue()))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    if (key.size() == 0) return -1;
    else return key.get(key.size() - 1);
  }
}
