package Algorithms.leetcodeAlgos.curatedAlgos;

import java.util.Arrays;

public class MinSwapsToSort {
  public static void main(String[] args) {
    int[] arr = new int[] {2, 4, 1, 3, 5};
    System.out.print(inversionCount(arr, arr.length));
  }

  public static int inversionCount(int[] arr, int N) {
    int ans = 0;
    int[] temp = Arrays.copyOfRange(arr, 0, N);
    Arrays.sort(temp);
    for (int i = 0; i < N; i++)
      if (arr[i] != temp[i]) {
        ans++;
        swap(arr, i, indexOf(arr, temp[i]));
      }

    return ans;
  }

  public static int indexOf(int[] arr, int ele) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == ele) {
        return i;
      }
    }
    return -1;
  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
