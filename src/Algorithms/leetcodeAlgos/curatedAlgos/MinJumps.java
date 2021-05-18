package Algorithms.leetcodeAlgos.curatedAlgos;

public class MinJumps {
  static int count = 0;

  public static void main(String[] args) {
    int[] arr = new int[] {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
    minJumps(arr, 0);
    System.out.print(count);
  }

  private static void minJumps(int[] arr, int pos) {
    if (arr[pos] >= arr.length - 1 - pos) {
      count++;
      return;
    }
    count++;
    minJumps(arr, pos + arr[pos]);
  }
}
