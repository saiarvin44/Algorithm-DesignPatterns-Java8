package Algorithms.hashing;

import java.util.HashSet;

public class PairWithGivenSumUnsortedArray {
  public static void main(String[] args) {
    int[] a = new int[] {3, 2, 8, 15, -8};
    boolean ans = isPair(a, 10);
    System.out.print(ans);
  }

  private static boolean isPair(int[] a, int sum) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < a.length; i++) {
      if (set.contains(sum - a[i])) return true;
      set.add(a[i]);
    }
    return false;
  }
}
