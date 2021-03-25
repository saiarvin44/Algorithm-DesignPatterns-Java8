package Algorithms.arrays;

public class MinGroupFlipsToMakeSame {
  public static void main(String[] args) {
    int[] arr = new int[] {1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1};
    int[] arr2 = new int[] {0, 0, 1, 1, 1};
    minFlips(arr2, arr2.length);
  }

  private static void minFlips(int[] arr, int length) {
    int elt = arr[0];
    for (int i = 1; i < length; i++) {
      if (arr[i] != arr[i - 1]) {
        if (arr[i] != arr[0]) System.out.print("From " + i + " To ");
        else System.out.print(i - 1);
      }
    }
    if (arr[length - 1] != arr[0]) System.out.println(length - 1);
  }
}
