package Algorithms.Backtracking;

public class MaxValueInAMaze {
  static boolean[][] visited;
  static int dp[][];

  public static void main(String[] args) {
    int[][] arr =
        new int[][] {
          {1, 2, 3, 0, 5},
          {0, 0, 2, 4, 0},
          {1, 2, 3, 0, 0}
        };

    visited = new boolean[arr.length][arr[0].length];
    dp = new int[arr.length][arr[0].length];
    int ans = findMax(arr, arr.length - 1, 0);
    System.out.print(ans);
  }

  private static int findMax(int[][] arr, int row, int col) {
    if (row == 0 && col == arr[0].length - 1) return arr[row][col];

    if (visited[row][col] != false) return dp[row][col];
    visited[row][col] = true;
    int total_sum = 0;

    if (row > 0 && col < arr[0].length - 1) {
      int curr_sum = Math.max(findMax(arr, row - 1, col), findMax(arr, row, col + 1));
      total_sum = arr[row][col] + curr_sum;
    } else if (row == 0 && col < arr[0].length)
      total_sum = arr[row][col] + findMax(arr, row, col + 1);
    else if (col == arr[0].length - 1 && row > 0)
      total_sum = arr[row][col] + findMax(arr, row - 1, col);
    dp[row][col] = total_sum;
    return total_sum;
  }
}
