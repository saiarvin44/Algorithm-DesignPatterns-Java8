package Algorithms.leetcodeAlgos.curatedAlgos;

import java.util.TreeSet;

class FirstMissingPositive {
  public static void main(String[] args) {
    int[] nums = new int[] {0, 2, 2, 1, 1};
    System.out.print(firstMissingPositive(nums));
  }

  public static int firstMissingPositive(int[] nums) {
    TreeSet<Integer> ts = new TreeSet<>();
    for (int num : nums) {
      ts.add(num);
    }
    int count = 1;
    for (int val : ts) {
      if (val <= 0) continue;
      if (val != count) {
        return count;
      } else {
        count++;
      }
    }
    return count;
  }
}
