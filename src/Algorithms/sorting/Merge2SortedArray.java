package Algorithms.sorting;

public class Merge2SortedArray {
  public static void main(String[] args) {
    int[] a = new int[] {10, 15, 20, 40};
    int[] b = new int[] {5, 6, 6, 10, 15};
    merge(a, b, a.length, b.length);
  }

  private static void merge(int[] a, int[] b, int m, int n) {
    int i = 0, j = 0;
    while (i < m && j < n) {
      if (a[i] < b[j]) System.out.print(a[i++] + " ");
      else System.out.print(b[j++] + " ");
    }
    while (i < m) System.out.print(a[i++] + " ");
    while (j < n) System.out.print(b[j++] + " ");
  }
}
