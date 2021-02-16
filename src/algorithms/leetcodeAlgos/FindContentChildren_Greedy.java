package algorithms.leetcodeAlgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindContentChildren_Greedy {
  public static void main(String[] args) {
    System.out.print(findContentChildren(new int[] {10, 9, 8, 7}, new int[] {5, 6, 7, 8}));
  }

  public static int findContentChildren(int[] g, int[] s) {
    List<Integer> gList = Arrays.stream(g).boxed().collect(Collectors.toList());
    List<Integer> sList = Arrays.stream(s).boxed().collect(Collectors.toList());
    Collections.sort(gList);
    Collections.sort(sList);
    int count = 0;
    for (int i = 0; i < gList.size(); i++)
      for (int j = 0; j < sList.size(); j++)
        if (sList.get(j) >= gList.get(i)) {
          sList.remove(j);
          count++;
          break;
        }
    return count;
  }
}
