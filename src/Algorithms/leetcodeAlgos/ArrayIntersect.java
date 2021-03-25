package Algorithms.leetcodeAlgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayIntersect {
  public static void main(String[] args) {
    System.out.print(intersect(new int[] {1, 2, 2, 1}, new int[] {2, 2})[0]);
  }

  public static int[] intersect(int[] nums1, int[] nums2) {
    List<Integer> nums1List = Arrays.stream(nums1).boxed().sorted().collect(Collectors.toList());
    List<Integer> nums2List = Arrays.stream(nums2).boxed().sorted().collect(Collectors.toList());
    List<Integer> ans = new ArrayList<>();
    int min = (nums1List.size() > nums2List.size()) ? nums2List.size() : nums1List.size();
    int max = (nums1List.size() > nums2List.size()) ? nums1List.size() : nums2List.size();
    int maxList = (nums1List.size() == max) ? 1 : 2;
    int h, l, m;
    for (int i = 0; i < min; i++) {
      if (maxList == 1) h = nums1List.size();
      else h = nums2List.size();
      l = 0;
      while (l <= h) {
        m = (l + h) / 2;
        if (maxList == 1) {
          if (nums2List.get(i) > nums1List.get(m)) l = m + 1;
          else if (nums2List.get(i) < nums1List.get(m)) h = m - 1;
          else {
            nums1List.remove(m);
            ans.add(nums2List.get(i));
            break;
          }
        } else {
          if (nums1List.get(i) > nums2List.get(m)) l = m + 1;
          else if (nums1List.get(i) < nums2List.get(m)) h = m - 1;
          else {
            nums2List.remove(m);
            ans.add(nums1List.get(i));
            break;
          }
        }
      }
    }

    return ans.stream().mapToInt(Integer::intValue).toArray();
  }
}
