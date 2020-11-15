package algorithms.sorting;

public class PartitionGivenArray {
  public static void main(String[] args) {
    int[] arr = new int[] {80, 10, 30, 90, 40, 50, 70};
    int pivotPos = lomutoPartition(arr, 0, arr.length - 1);
    int pivotPosAgain = hoaresPartition(arr, 0, arr.length - 1);
    for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
  }

  private static int hoaresPartition(int[] arr, int l, int h) {
    int pivot = arr[l];
    int i = l - 1, j = h + 1;
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
