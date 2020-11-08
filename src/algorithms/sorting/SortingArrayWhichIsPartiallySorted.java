package algorithms.sorting;

public class SortingArrayWhichIsPartiallySorted {
  public static void main(String[] args) {
    int[] arr = new int[] {10, 15, 20, 40, 8, 11, 15, 22, 25};
    int l = 0, h = arr.length, m = 3; // l to m is sorted, m+1 to h is sorted
    merge(arr, l, m, h);
  }

  private static void merge(int[] arr, int l, int m, int h) {
    int n1 = m - l + 1;
    int n2 = h - m;
    int[] left = new int[n1], right = new int[n2];
    for (int i = 0; i < n1; i++) left[i] = arr[l + i];
    for (int j = 0; j < n2; j++) right[j] = arr[m + 1 + j];
    int i = 0, j = 0, k = l;
    while (i < n1 && j < n2) {
      if (left[i] <= right[j]) arr[k++] = left[i++];
      else arr[k++] = right[j++];
    }
    while (i < n1) arr[k++] = left[i++];
    while (j < n2) arr[k++] = right[j++];
  }
}
