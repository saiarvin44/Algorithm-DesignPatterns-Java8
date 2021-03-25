package Algorithms.sorting;

public class InsertionSort {
  public static void main(String[] args) {
    int[] arr = new int[] {20, 50, 40, 60, 10, 30};
    int[] arr2 = new int[] {4, 3, 2,10, 12, 1, 5, 6};
    sort(arr2, arr2.length);
    System.out.println(arr2[0]);
  }

  private static void sort(int[] arr, int length) {
    for (int i = 1; i < length; i++) {
      int key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
  }
}
