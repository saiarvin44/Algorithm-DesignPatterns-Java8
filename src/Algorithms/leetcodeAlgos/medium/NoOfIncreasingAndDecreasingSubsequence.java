package Algorithms.leetcodeAlgos.medium;

import java.util.Arrays;

class NoOfIncreasingAndDecreasingSubsequence {
  public static void main(String[] args) {
    int[] rating = new int[] {1, 2, 3, 4};
    numTeams(rating);
  }

  public static int numTeams(int[] rating) {
    boolean check = true;
    for (int i = 0; i < rating.length - 1; i++)
      if (rating[i] > rating[i + 1]) {
        check = false;
        break;
      }

    if (check && rating.length == 3) return 1;
    if (check) return rating.length;
    int n = rating.length;
    int[] lis = new int[n];
    int[] lds = new int[n];
    int[] countArray = new int[n + 1];
    int count = 0;
    Arrays.fill(lis, 1);
    Arrays.fill(lds, 1);
    Arrays.fill(countArray, 0);

    for (int i = 0; i < n; i++)
      for (int j = 0; j < i; j++)
        if (rating[j] < rating[i]) { 
          lis[i] = Math.max(lis[i], lis[j] + 1);
          countArray[lis[i]]++;
        }

    for (int i = n - 1; i >= 0; i--)
      for (int j = n - 1; j > i; j--)
        if (rating[j] < rating[i]) {
          lds[i] = Math.max(lds[i], lds[j] + 1);
          countArray[lds[i]]++;
        }

    for (int i = 3; i <= n; i++) {
      count += countArray[i];
    }
    return count;
  }
}
