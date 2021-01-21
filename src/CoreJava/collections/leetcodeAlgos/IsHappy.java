package CoreJava.collections.leetcodeAlgos;

import java.util.HashSet;
import java.util.Set;

public class IsHappy {
  public static void main(String[] args) {
    System.out.print("Is number happy : " + isHappy(19));
  }

  public static boolean isHappy(int n) {
    Set<Integer> set = new HashSet<>();
    int mod;
    int sum;
    if (n == 1) return true;
    int temp2;
    sum = n;
    while (sum != 1) {
      temp2 = sum;
      sum = 0;
      while (temp2 != 0) {
        mod = temp2 % 10;
        sum += (mod * mod);
        temp2 /= 10;
      }
      if (set.contains(sum)) return false;
      set.add(sum);
    }
    return true;
  }
}
