package CoreJava.collections;

public class IntegerAlgos {
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

  public static void main(String[] args) {
    int[] ans = searchRange(new int[] {1, 4}, 4);
    System.out.print(ans[0] + ":" + ans[1]);
  }

  public static int[] searchRange(int[] nums, int target) {
    boolean found = false, secondFound = false;
    int[] ans = new int[] {-1, -1};
    int n = nums.length;
    if (nums.length == 0) return ans;
    if (n == 1) {
      if (nums[0] == target) return new int[] {0, 0};
      else return new int[] {-1, -1};
    }
    for (int i = 0; i < n - 1; i++) {
      if (nums[i] == target) {
        if (ans[0] == -1) ans[0] = i;
        found = true;
        if (nums[i + 1] == target) {
          ans[1] = i + 1;
          secondFound = true;
          found = true;
        }
      }
    }
    if (!secondFound) ans[1] = ans[0];
    if (!found) {
      if (nums[n - 1] == target) {
        ans[0] = n - 1;
        ans[1] = n - 1;
      }
    }
    return ans;
  }
}
