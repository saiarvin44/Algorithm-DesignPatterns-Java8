package CoreJava.collections.leetcodeAlgos;

import java.util.ArrayList;

public class IsPalindrome {
  public static void main(String[] args) {
    System.out.println(isPalindrome(10));
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
}
