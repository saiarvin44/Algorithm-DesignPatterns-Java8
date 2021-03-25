package Algorithms.sorting;

public class UnionOfSortedArrays {
  public static void main(String[] args) {
    int[] a = new int[] {3, 8, 8};
    int[] b = new int[] {2, 8, 8, 10, 15};
    printUnion(a, b, a.length, b.length);
  }

  private static void printUnion(int[] a, int[] b, int n, int m) {
    int i = 0, j = 0;
    while (i < n && j < m) {
      if (i > 0 && a[i] == a[i - 1]) {
        i++;
        continue;
      }
      if (j > 0 && b[j] == b[j - 1]) {
        j++;
        continue;
      }
      if (a[i] < b[j]) {
        System.out.print(a[i] + " ");
        i++;
      } else if (b[j] < a[i]) {
        System.out.print(b[j] + " ");
        j++;
      } else {
        System.out.print(a[i] + " ");
        i++;
        j++;
      }
    }
    while (i < n) {
      if (i == 0 || a[i] != a[i - 1]) {
        System.out.print(a[i] + " ");
      }
      i++;
    }
    while (j < m) {
      if (j == 0 || b[j] != b[j - 1]) {
        System.out.print(b[j] + " ");
      }
      j++;
    }
  }
}
