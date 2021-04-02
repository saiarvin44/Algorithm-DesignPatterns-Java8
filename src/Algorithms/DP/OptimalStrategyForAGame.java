package Algorithms.DP;

public class OptimalStrategyForAGame {
  public static void main(String[] args) {
    int[] arr = new int[] {20, 5, 4, 6};
    mainSol(arr, arr.length);
  }

  private static void mainSol(int[] arr, int n) {
    int sum = 0;
    for (int i = 0; i < n; i++) sum += arr[i];
    int ans1 = sol1(arr, 0, n - 1, sum);
    int ans2 = sol2(arr, 0, n - 1);
  }

  private static int sol1(int[] arr, int i, int j, int sum) {
    if (j == i + 1) return Math.max(arr[i], arr[j]);
    return Math.max(
        sum - sol1(arr, i + 1, j, sum - arr[i]), sum - sol1(arr, i, j - 1, sum - arr[j]));
  }

  private static int sol2(int[] arr, int i, int j) {
    if (i + 1 == j) return Math.max(arr[i], arr[j]);
    return Math.max(
        arr[i] + Math.min(sol2(arr, i + 2, j), sol2(arr, i + 1, j - 1)),
        arr[j] + Math.min(sol2(arr, i + 1, j - 1), sol2(arr, i, j - 2)));
  }
}
