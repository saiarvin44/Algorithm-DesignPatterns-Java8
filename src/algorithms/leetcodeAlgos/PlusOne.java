package algorithms.leetcodeAlgos;

public class PlusOne {
  public static void main(String[] args) {
    int[] ans3 = plusOne(new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
    for (int i = 0; i < ans3.length; i++) System.out.print(ans3[i] + " ");
  }

  public static int[] plusOne(int[] digits) {
    int n = digits.length;
    long sum = 0;
    for (int i = 0; i < n; i++) sum += digits[i] * Math.pow(10, (n - i - 1));
    sum += 1;
    String temp = Long.toString(sum);
    int[] ans = new int[temp.length()];
    for (int i = 0; i < temp.length(); i++) {
      ans[i] = temp.charAt(i) - '0';
    }
    return ans;
  }
}
