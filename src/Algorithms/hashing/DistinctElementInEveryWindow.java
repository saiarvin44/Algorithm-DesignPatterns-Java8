package Algorithms.hashing;

import java.util.HashSet;

public class DistinctElementInEveryWindow {
  public static void main(String[] args) {
    int[] arr = new int[] {10, 20, 10, 10, 30, 40};
    int k = 4;
    printDistinct(arr, k);
  }

  private static void printDistinct(int[] arr, int k) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < 4; i++) {
      set.add(arr[i]);
    }
    for (Integer elt : set) System.out.print(elt + " ");
    System.out.println();
    for (int i = 1; i < arr.length - k + 1; i++) {
      set.remove(arr[i - 1]);
      for (int j = i; j < i + 4; j++) set.add(arr[j]);
      for (Integer elt : set) System.out.print(elt + " ");
      System.out.println();
    }
  }
}
