package Algorithms.leetcodeAlgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Generate {
  public List<List<Integer>> generate(int numRows) {
    int[][] ans = new int[numRows][];
    for (int i = 0; i < numRows; i++) ans[i] = new int[i + 1];
    ans[0][0] = 1;
    List<List<Integer>> finalAns = new ArrayList<>();
    if (numRows == 0) return null;
    else if (numRows == 1) {
      List<Integer> list = Arrays.stream(ans[0]).boxed().collect(Collectors.toList());
      finalAns.add(list);
      return finalAns;
    } else {
      ans[1][0] = 1;
      ans[1][1] = 1;
      for (int i = 2; i < numRows; i++) {
        ans[i][0] = 1;
        ans[i][ans[i].length - 1] = 1;
        for (int j = 1; j < ans[i].length - 1; j++) {
          ans[i][j] = ans[i - 1][j - 1] + ans[i - 1][j];
        }
      }
      for (int i = 0; i < numRows; i++) {
        List<Integer> list = Arrays.stream(ans[i]).boxed().collect(Collectors.toList());
        finalAns.add(list);
      }
      return finalAns;
    }
  }
}
