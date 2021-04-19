package Algorithms.leetcodeAlgos.medium;

import java.util.*;

class FindingUserActiveMinutes {
  public static void main(String[] args) {
    int[][] input = new int[][] {{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}};
    int k = 5;
    System.out.println(findingUsersActiveMinutes(input, k));
  }

  public static int[] findingUsersActiveMinutes(int[][] logs, int k) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Map<Integer, Integer> finalMap = new HashMap<>();
    int[] ans = new int[k];
    for (int i = 0; i < logs.length; i++) {
      if (map.containsKey(logs[i][0])) {
        List<Integer> list = new ArrayList<>(map.get(logs[i][0]));
        if (!list.contains(logs[i][1])) {

          list.add(logs[i][1]);
          map.put(logs[i][0], list);
        }
      } else {
        map.put(logs[i][0], Arrays.asList(logs[i][1]));
      }
    }

    List<Integer> list;
    for (Map.Entry entry : map.entrySet()) {
      list = (List<Integer>) entry.getValue();
      finalMap.put(list.size(), finalMap.getOrDefault(list.size(), 0) + 1);
    }

    for (Map.Entry entry : finalMap.entrySet()) {
      ans[(int) entry.getKey()-1] = (int) entry.getValue();
    }
    return ans;
  }
}
