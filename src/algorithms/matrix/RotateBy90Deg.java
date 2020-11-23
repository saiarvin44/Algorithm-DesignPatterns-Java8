package algorithms.matrix;

public class RotateBy90Deg {
  public static void main(String[] args) {
    int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    rotate(arr);
  }

  private static void rotate(int[][] arr) {
    transpose(arr);
    reverseColumns(arr);
  }

  private static void reverseColumns(int[][] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      int low = 0, high = n - 1;
      while (low < high) {
        swapColumns(arr, low, high, i);
        low++;
        high--;
      }
    }
  }

  private static void swapColumns(int[][] arr, int low, int high, int i) {
    int temp = arr[low][i];
    arr[low][i] = arr[high][i];
    arr[high][i] = temp;
  }

  private static void transpose(int[][] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) swapElts(arr, i, j);
  }

  private static void swapElts(int[][] arr, int i, int j) {
    int temp = arr[i][j];
    arr[i][j] = arr[j][i];
    arr[j][i] = temp;
  }
}
