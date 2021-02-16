package algorithms.leetcodeAlgos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MatrixCellsInDistanceOrder {
  public static void main(String[] args) {
    System.out.print(allCellsDistOrder(2, 2, 0, 1));
  }

  public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
    List<List<Integer>> list = new ArrayList<>();
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        List<Integer> t = new ArrayList<>();
        t.add(i);
        t.add(j);
        list.add(t);
      }
    }
    Collections.sort(
        list,
        new Comparator<List<Integer>>() {
          @Override
          public int compare(List<Integer> a, List<Integer> b) {
            return (Math.abs(a.get(0) - r0) + Math.abs(a.get(1) - c0))
                - (Math.abs(b.get(0) - r0) + Math.abs(b.get(1) - c0));
          }
        });

    int[][] ans = new int[R * C][2];
    for (int i = 0; i < list.size(); i++) {
      List<Integer> temp = list.get(i);
      ans[i][0] = temp.get(0);
      ans[i][1] = temp.get(1);
    }
    return ans;
  }
}
