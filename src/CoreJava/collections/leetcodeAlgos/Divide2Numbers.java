package CoreJava.collections.leetcodeAlgos;

public class Divide2Numbers {
  public static int divide(int dividend, int divisor) {
    boolean negative = false;
    int ans = 0;
    if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
    if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
    if (Math.abs(divisor) > Math.abs(dividend)) return 0;
    if (dividend < 0 && divisor < 0) negative = false;
    else if (dividend < 0 || divisor < 0) negative = true;
    dividend = Math.abs(dividend);
    while (dividend >= 0) {
      dividend = Math.abs(dividend) - Math.abs(divisor);
      if (dividend >= 0) ans++;
    }
    if (negative) return (-1 * ans);
    return ans;
  }
}
