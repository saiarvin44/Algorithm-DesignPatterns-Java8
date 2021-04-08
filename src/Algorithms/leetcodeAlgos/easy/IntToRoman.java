package Algorithms.leetcodeAlgos.easy;

import java.util.HashMap;
import java.util.Map;

public class IntToRoman {
  public static void main(String[] args) {
    System.out.println(intToRoman(58));
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
