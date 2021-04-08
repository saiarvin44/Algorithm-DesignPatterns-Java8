package Algorithms.leetcodeAlgos.medium;

import java.util.ArrayList;
import java.util.List;

public class MinOperationsToReinitializePermutation {
  public static void main(String[] args) {
    int n = 4;
    System.out.println(minOperations(n));
  }

  private static int minOperations(int n) {
    List<Integer> perm = new ArrayList<>();
    for (int i = 0; i < n; i++) perm.add(i);
    List<Integer> copy = new ArrayList<>();
    List<Integer> finalArr = new ArrayList<>(perm);
    int count = 0;
    do {
      for (int i = 0; i < perm.size(); i++) {
        if (count < 1) {
          if (i % 2 == 0) copy.add(i, perm.get(i / 2));
          else copy.add(i, perm.get(n / 2 + (i - 1) / 2));
        } else {
          if (i % 2 == 0) copy.set(i, perm.get(i / 2));
          else copy.set(i, perm.get(n / 2 + (i - 1) / 2));
        }
      }
      perm = new ArrayList<>(copy);
      count++;
    } while (!finalArr.equals(perm));
    return count;
  }
}
