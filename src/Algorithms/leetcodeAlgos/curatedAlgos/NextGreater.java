package Algorithms.leetcodeAlgos.curatedAlgos;

import java.util.Arrays;

public class NextGreater {
  public static void main(String[] args) {
    int n = 4321;
    System.out.print(findNextGreater(n));
  }

  private static int findNextGreater(int n) {
    int t = n;
    int j = 0;
    int len = Integer.toString(n).length();
    int[] arr = new int[len];
    while (t != 0) {
      arr[len - j - 1] = t % 10;
      t /= 10;
      j++;
    }
    int pos1 = -1;
    int pos2 = -1;
    for (int i = len - 1; i > 0; i--) {
      if (arr[i] > arr[i - 1]) {
        pos1 = i - 1;
        break;
      }
    }
    if (pos1 == -1) return -1;
    int min = arr[pos1 + 1];
    for (int i = pos1 + 1; i < len; i++)
      if (arr[i] < min) {
        min = arr[i];
        pos2 = i;
      }

    swap(arr, pos1, pos2);
    Arrays.sort(arr, pos1 + 1, len);

    int sum = 0;
    for (int i = 0; i < len; i++) {
      sum += Math.pow(10, len - i - 1) * arr[i];
    }
    return sum;
  }

  private static void swap(int[] arr, int pos1, int pos2) {
    int temp = arr[pos1];
    arr[pos1] = arr[pos2];
    arr[pos2] = temp;
  }
}
