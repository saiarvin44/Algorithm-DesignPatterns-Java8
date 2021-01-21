package CoreJava.collections.leetcodeAlgos;

import java.util.HashMap;
import java.util.Map;

public class RemoveElement {
  public static void main(String[] args) {
    System.out.println(removeElement(new int[] {3, 2, 2, 3}, 3));
  }

  public static int removeElement(int[] nums, int val) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(i, nums[i]);
    }
    for (int i = 0; i < nums.length; i++) {
      if (map.get(i) == val) map.remove(i);
    }
    return map.size();
  }
}
