package Algorithms.sorting;

public class Sort3TypesOfElements {
  public static void main(String[] args) {
    // Dusnational algorithm
    int[] arr = new int[] {0, 1, 2, 1, 1, 2};
    sort3Types(arr, arr.length);
    for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
  }

  private static void sort3Types(int[] arr, int n) {
    int lo = 0, hi = n - 1, mid = 0;
    while (mid <= hi) {
      switch (arr[mid]) {
        case 0:
          swapElts(arr, lo, mid);
          lo++;
          mid++;
          break;
        case 1:
          mid++;
          break;
        case 2:
          swapElts(arr, mid, hi);
          hi--;
          break;
      }
    }
  }

  private static void swapElts(int[] arr, int lo, int mid) {
    int temp = arr[lo];
    arr[lo] = arr[mid];
    arr[mid] = temp;
  }
}
