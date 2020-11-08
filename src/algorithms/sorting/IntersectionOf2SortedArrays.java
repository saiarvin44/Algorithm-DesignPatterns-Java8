package algorithms.sorting;

public class IntersectionOf2SortedArrays {
  public static void main(String[] args) {
    int[] a = new int[] {2, 5, 8, 13, 15};
    int[] b = new int[] {1, 3, 8, 15, 18, 20, 25};
    intersection(a, b, a.length, b.length);
  }

  private static void intersection(int[] a, int[] b, int m, int n) {
    int i = 0, j = 0;
    while (i < m && j < n) {
      if (i > 0 && a[i - 1] == a[i]) {
        i++;
        continue;
      }
      if (a[i] > b[j]) j++;
      else if (a[i] < b[j]) i++;
      else {
        System.out.print(a[i] + " ");
        i++;
        j++;
      }
    }
  }
}
