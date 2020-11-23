package algorithms.matrix;

public class SearchingEltInRowColSortedMtx {
  public static void main(String[] args) {
    int[][] arr = {{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}};
    searchElt(arr, arr.length, 39);
  }

  private static void searchElt(int[][] arr, int n, int x) {
    int i = 0, j = n - 1;
    while (i < n && j >= 0) {
      if (arr[i][j] == x) {
        System.out.print("found at : " + i + " " + j);
        return;
      } else if (arr[i][j] > x) j--;
      else i++;
    }
    System.out.print("Not found");
  }
}
