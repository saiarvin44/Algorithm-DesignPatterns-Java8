package algorithms.sorting;

public class QuickSortUsingHoarePartition {
  public static void main(String[] args) {
    int[] arr = new int[] {8, 4, 7, 9, 3, 10, 5};
    quickSort(arr, 0, arr.length - 1);
    for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
  }

  private static void quickSort(int[] arr, int l, int h) {
    if (l < h) {
      int p = partition(arr, l, h);
      quickSort(arr, l, p);
      quickSort(arr, p + 1, h);
    }
  }

  private static int partition(int[] arr, int l, int h) {
    int i = l - 1, j = h + 1, pivot = arr[l];
    while (true) {
      do {
        i++;
      } while (arr[i] < pivot);
      do {
        j--;
      } while (arr[j] > pivot);
      if (i >= j) return j;
      swapElts(arr, i, j);
    }
  }

  private static void swapElts(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
