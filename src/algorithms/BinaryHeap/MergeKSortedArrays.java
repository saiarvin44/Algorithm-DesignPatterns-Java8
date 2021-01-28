package algorithms.BinaryHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeKSortedArrays {
  public static void main(String[] args) {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> row1 = Arrays.asList(10, 20, 30);
    List<Integer> row2 = Arrays.asList(5, 15);
    List<Integer> row3 = Arrays.asList(1, 9, 11, 18);
    list.add(row1);
    list.add(row2);
    list.add(row3);
    mergeSortedArrays(list);
  }

  private static void mergeSortedArrays(List<List<Integer>> list) {}
}
