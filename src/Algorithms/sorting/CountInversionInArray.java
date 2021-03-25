package Algorithms.sorting;

public class CountInversionInArray {
  public static void main(String[] args) {
    int[] arr = new int[] {2, 4, 1, 3, 5};
    int max = inversion(arr, 0, arr.length - 1); // inversion is defined as  i<j and arr[i]>arr[j]
    System.out.print(max);
  }

  private static int inversion(int[] arr, int l, int r) {
    int res = 0;
    if (l < r) {
      int m = (l + r) / 2;
      res += inversion(arr, l, m);
      res += inversion(arr, m + 1, r);
      res += countAndMerge(arr, l, m, r);
    }
    return res;
  }

  private static int countAndMerge(int[] arr, int l, int m, int r) {
    int n1 = m - l + 1, n2 = r - m;
    int[] left = new int[n1], right = new int[n2];
    for (int i = 0; i < n1; i++) left[i] = arr[l + 1];
    for (int j = 0; j < n2; j++) right[j] = arr[m + 1 + j];
    int res = 0, i = 0, j = 0, k = l;
    while (i < n1 && j < n2) {
      if (left[i] <= right[j]) arr[k] = left[i++];
      else {
        arr[k] = right[j++];
        res = res + (n1 - i); // n1-i because if it is smaller,
      }                       // it'll be smaller till elt at j
      k++;
    }
    while (i < n1) {
      arr[k] = left[i++];
      k++;
    }
    while (j < n2) {
      arr[k] = right[j++];
      k++;
    }
    return res;
  }
}
