package Algorithms.arrays;

public class NumberOfSquareSubMatrix {
  public static void main(String[] args) {
    int[][] mtx =
        new int[][] {
          {0, 1, 1, 1},
          {
            1, 1, 1, 1,
          },
          {0, 1, 1, 1}
        };
    int[][] dp =
        new int[][] {
          {0, 0, 0, 0},
          {
            0, 0, 1, 1,
          },
          {0, 0, 1, 2}
        };
    countSquares(mtx);
  }

  private static int countSquares(int[][] matrix) {
    int dp[][] = new int[matrix.length][matrix[0].length];
    int ans = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        // 1st check
        if (matrix[i][j] == 1) ans += 1;

        // 2nd check
        if (i > 0 && j > 0 && matrix[i][j] == 1) {

          int tmp = Math.min(matrix[i - 1][j], Math.min(matrix[i][j - 1], matrix[i - 1][j - 1]));
          int tmp2 = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));

          dp[i][j] = tmp + tmp2;
        }
        ans += dp[i][j];
      }
    }
    return ans;
  }
}
