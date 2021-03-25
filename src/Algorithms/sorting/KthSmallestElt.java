package Algorithms.sorting;

public class KthSmallestElt {
  public static void main(String[] args) {
    int[] arr = new int[] {10, 4, 5, 8, 11, 6, 26};
    int pos = KthSmallest(arr, arr.length, 1);
    System.out.print(arr[pos]);
  }

  private static int KthSmallest(int[] arr, int n, int k) {
    int l = 0, r = n - 1;
    while (l <= r) {
      int p = LomutoPartition(arr, l, r);
      if (p == k - 1) return p;
      else if (p > k - 1) r = p - 1;
      else r = p + 1;
    }
    return -1;
  }

  private static int LomutoPartition(int[] arr, int l, int r) {
    int pivot = arr[r];
    int i = l - 1;
    for (int j = l; j <= r; j++) {
      if (arr[j] < pivot) {
        i++;
        swapElts(arr, i, j);
      }
    }
    swapElts(arr, i + 1, r);
    return i + 1;
  }

  private static void swapElts(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
