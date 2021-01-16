package CoreJava.collections;

import java.util.*;

public class Algos {
  public static void main(String[] args) {
    int[] arr = new int[] {1, 2, 4, 8, 16, 32, 64, 128};
    int target = 82;
    System.out.println("3Sum closest : " + threeSumClosest(arr, target));
    System.out.println("Valid brackets : " + isValid("([)]"));
    System.out.println(isPalindrome(10));
    System.out.println(threeSum(new int[] {-1, 2, 1, -4}));
    System.out.println(intToRoman(58));
  }

  public static boolean isPalindrome(int x) {
    if (x < 0) return false;
    ArrayList<Integer> list = new ArrayList<>();
    while (x != 0) {
      list.add(x % 10);
      x /= 10;
    }
    int j = list.size() - 1;
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) != list.get(j--)) return false;
    }
    return true;
  }

  public static boolean isValid(String s) {
    boolean result = true;
    Queue<Character> queue = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') queue.add(s.charAt(i));
    }
    if (queue.isEmpty()) return false;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') continue;
      Character poppedBracket = null;
      if (!queue.isEmpty()) poppedBracket = queue.remove();
      if (!((poppedBracket == '(' && s.charAt(i) == ')')
          || (poppedBracket == '{' && s.charAt(i) == '}')
          || (poppedBracket == '[' && s.charAt(i) == ']'))) {
        result = false;
        break;
      }
    }
    if (!queue.isEmpty()) return false;
    return result;
  }

  public static int threeSumClosest(int[] nums, int target) {
    int res;
    int n = nums.length;
    Arrays.sort(nums);
    res = nums[n - 1] + nums[n - 2] + nums[n - 3];
    for (int i = 0; i < n - 2; i++) {
      int j = i + 1;
      int k = n - 1;
      while (j < k) {
        int temp = nums[i] + nums[j] + nums[k];
        if ((Math.abs((temp - target)) < Math.abs((res - target)))) res = temp;
        if (temp < target) j++;
        else k--;
      }
    }
    return res;
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    int n = nums.length;
    List<Integer> sub = null;
    for (int i = 0; i < n - 2; i++) {
      for (int j = i + 1; j < n - 1; j++) {
        for (int k = j + 1; k < n; k++)
          if (nums[i] + nums[j] + nums[k] == 0) {
            sub = new ArrayList<>();
            sub.add(nums[i]);
            sub.add(nums[j]);
            sub.add(nums[k]);
            ans.add(sub);
          }
      }
    }
    return ans;
  }

  public static String intToRoman(int num) {
    Map<Integer, String> map = new HashMap<>();
    String ans = "";
    map.put(1, "I");
    map.put(5, "V");
    map.put(10, "X");
    map.put(50, "L");
    map.put(100, "C");
    map.put(500, "D");
    map.put(1000, "M");

    int rev = 0, n = -1;
    int t = 0;
    while (num != 0) {
      rev = (rev * 10) + (num % 10);
      num /= 10;
      n++;
    }
    while (rev != 0) {
      t = (int) ((rev % 10) * Math.pow(10, n--));
      rev /= 10;
      if (map.containsKey(t)) ans += map.get(t);
      else if (t == 4) ans = ans + map.get(1) + map.get(5);
      else if (t == 9) ans = ans + map.get(1) + map.get(10);
      else if (t == 40) ans = ans + map.get(10) + map.get(50);
      else if (t == 90) ans = ans + map.get(10) + map.get(100);
      else if (t == 400) ans = ans + map.get(100) + map.get(500);
      else if (t == 900) ans = ans + map.get(100) + map.get(1000);
      else {
        if ((n + 1) == 3) {
          for (int i = 0; i < (t / 1000); i++) ans += map.get(1000);
        } else if ((n + 1) == 2) {
          if (t <= 300) {
            for (int i = 0; i < (t / 100); i++) ans += map.get(100);
          } else {
            ans += map.get(500);
            int temp = t - 500;
            for (int i = 0; i < (temp / 100); i++) ans += map.get(100);
          }
        } else if ((n + 1) == 1) {
          if (t <= 30) {
            for (int i = 0; i < (t / 10); i++) ans += map.get(10);
          } else {
            ans += map.get(50);
            int temp = t - 50;
            for (int i = 0; i < (temp / 10); i++) ans += map.get(10);
          }
        } else {
          if (t <= 3) {
            for (int i = 0; i < t; i++) ans += map.get(1);
          } else {
            ans += map.get(5);
            int temp = t - 5;
            for (int i = 0; i < temp; i++) ans += map.get(1);
          }
        }
      }
    }

    return ans;
  }
}
