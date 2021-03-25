package Algorithms.hashing;

import java.util.HashSet;

public class Intersection2ArraysCount {
  public static void main(String[] args) {
    int[] a = new int[] {10, 15, 20, 15, 30, 30, 5};
    int[] b = new int[] {30, 5, 30, 80};
    int res = intersection(a, b);
    System.out.print(res);
  }

  private static int intersection(int[] a, int[] b) {
    int la = a.length;
    int lb = b.length;
    HashSet<Integer> s = new HashSet<>();
    for (int i = 0; i < la; i++) s.add(a[i]);
    int res = 0;
    for (int j = 0; j < lb; j++) {
      if (s.contains(b[j])) {
        res++;
        s.remove(b[j]);
      }
    }
    return res;
  }
}
