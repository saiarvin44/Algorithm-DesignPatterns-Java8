package Algorithms.BinarySearchTree;

import java.util.TreeSet;

public class CeilOnLeftSide {
  public static void main(String[] args) {
    printCeiling(new int[] {2, 8, 30, 15, 25, 12});
  }

  public static void printCeiling(int[] arr) {
    System.out.print(-1 + " ");
    TreeSet<Integer> set = new TreeSet<>();
    set.add(arr[0]);
    for (int i = 1; i < arr.length; i++) {
      if (set.ceiling(arr[i]) != null) System.out.print(set.ceiling(arr[i]) + " ");
      else System.out.print(-1 + " ");
      set.add(arr[i]);
    }
  }
}
