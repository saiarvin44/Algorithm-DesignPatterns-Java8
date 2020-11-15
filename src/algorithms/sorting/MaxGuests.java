package algorithms.sorting;

import java.util.Arrays;

public class MaxGuests {
  public static void main(String[] args) {
    int[] arr = new int[] {900, 600, 700}; // represents time
    int[] dep = new int[] {1000, 800, 730};
    int max = maxGuests(arr, dep);
  }

  private static int maxGuests(int[] arr, int[] dep) {
    Arrays.sort(arr);
    Arrays.sort(dep);
    int i = 1, j = 0, res = 1, curr = 1;
    int n = arr.length;
    while (i < n && j < n) {
      if (arr[i] <= dep[j]) {
        curr++;
        i++;
      } else {
        curr--;
        j++;
      }
      res = Math.max(res, curr);
    }
    return res;
  }
}
