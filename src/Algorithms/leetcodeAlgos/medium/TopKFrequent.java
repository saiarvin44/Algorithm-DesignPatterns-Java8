package Algorithms.leetcodeAlgos.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TopKFrequent {
  public static void main(String[] args) {
    topKFrequent(new int[] {3, 0, 1, 0}, 1);
  }

  public static int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    List<Integer> list = new ArrayList<>();
    for (Map.Entry entry : map.entrySet()) {
      if ((Integer) entry.getValue() >= k) list.add((Integer) entry.getKey());
    }
    if (list.size() == 0) return nums;
    int[] finalAns = list.stream().mapToInt(i -> i).toArray();
    return finalAns;
  }
}
