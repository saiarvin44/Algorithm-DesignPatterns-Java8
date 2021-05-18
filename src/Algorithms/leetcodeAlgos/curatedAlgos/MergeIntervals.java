package Algorithms.leetcodeAlgos.curatedAlgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
  public static void main(String[] args) {
    int[][] intervals = new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    mergeInterval(intervals);
  }

  private static int[][] mergeInterval(int[][] intervals) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(intervals, Comparator.comparingInt(obj -> obj[0]));
    List<Integer> temp = null;
    for (int i = 0; i < intervals.length; i++) {
      while (i < intervals.length - 1
          && intervals[i][1] >= intervals[i + 1][0]
          && intervals[i][1] <= intervals[i + 1][1]) {
        temp = new ArrayList<>();
        temp.add(intervals[i][0]);
        temp.add(intervals[i + 1][1]);
        i++;
      }
      if (temp != null) ans.add(temp);
      else ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));
      temp = null;
    }
    int[][] finalAns =
        ans.stream().map(u -> u.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new);
    return finalAns;
  }
}
