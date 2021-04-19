package Algorithms.leetcodeAlgos.medium;

import java.util.*;
import java.util.stream.Collectors;

class RemoveMinimumSet {
  public static void main(String[] args) {
    minSetSize(new int[] {3, 3, 3, 3, 5, 5, 5, 2, 2, 7});
  }

  public static int minSetSize(int[] arr) {
    Arrays.sort(arr);
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i]) + 1);
      else map.put(arr[i], 1);
    }

    Map<Integer, Integer> sortedMap =
        map.entrySet().stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    int ans = 0, count = 0;
    for (Map.Entry entry : sortedMap.entrySet()) {
      count += (int) entry.getValue();
      ans++;
      if (count >= (arr.length / 2)) break;
    }
    return ans;
  }
}
