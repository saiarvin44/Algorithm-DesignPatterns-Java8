package algorithms.BinaryHeap;

public class HeapSort {
  public static void main(String[] args) {
    heapSort(new int[] {20, 50, 10, 4, 15}, 5);
  }

  private static void heapSort(int[] arr, int n) {
    buildHeap(arr, n);
    for (int i = n - 1; i >= 1; i--) {
      swapElts(arr, 0, i);
      maxHeapify(arr, i, 0);
    }
  }

  public static void buildHeap(int[] arr, int n) {
    for (int i = (n - 2) / 2; i >= 0; i--) maxHeapify(arr, n, i);
  }

  private static void maxHeapify(int[] arr, int n, int i) {
    int lt = (2 * i) + 1, rt = (2 * i) + 2;
    int largest = i;
    if (lt < n && arr[lt] > arr[largest]) largest = lt;
    if (rt < n && arr[rt] > arr[largest]) largest = rt;
    if (largest != i) {
      swapElts(arr, largest, i);
      maxHeapify(arr, n, largest);
    }
  }

  private static void swapElts(int[] arr, int largest, int i) {
    int temp = arr[largest];
    arr[largest] = arr[i];
    arr[i] = temp;
  }
}
