package Algorithms.sorting;

public class QuickSortUsingLomutoPartition {
  public static void main(String[] args) {
    int[] arr = new int[] {8, 4, 7, 8, 3, 10, 5};
    quickSort(arr, 0, arr.length - 1);
    for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
  }

  private static void quickSort(int[] arr, int l, int h) {
    if (l < h) {
      int p = lomutoPartition(arr, l, h);
      quickSort(arr, l, p - 1);
      quickSort(arr, p + 1, h);
    }
  }

  private static int lomutoPartition(int[] arr, int l, int h) {
    int pivot = arr[h];
    int i = l - 1;
    for (int j = l; j <= h - 1; j++) {
      if (arr[j] < pivot) {
        i++;
        swapElts(arr, i, j);
      }
    }
    swapElts(arr, i + 1, h);
    return i + 1;
  }

  private static void swapElts(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
