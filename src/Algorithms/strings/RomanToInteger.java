package Algorithms.strings;

public class RomanToInteger {
  public static void main(String[] args) {
    String roman = "MCMIV";
    int ans = findInt(roman);
    System.out.print(ans);
  }

  private static int findInt(String roman) {
    int res = 0;
    for (int i = 0; i < roman.length(); i++) {
      int s1 = findVal(roman.charAt(i));
      if (i + 1 < roman.length()) {
        int s2 = findVal(roman.charAt(i + 1));
        if (s1 >= s2) res = res + s1;
        else {
          res = res + s2 - s1;
          i++;
        }
      } else res = res + s1;
    }
    return res;
  }

  private static int findVal(char c) {
    if (c == 'I') return 1;
    if (c == 'V') return 5;
    if (c == 'X') return 10;
    if (c == 'L') return 50;
    if (c == 'C') return 100;
    if (c == 'D') return 500;
    if (c == 'M') return 1000;
    return -1;
  }
}
