package CoreJava.collections.leetcodeAlgos;

public class AddBinary {
  public static void main(String[] args) {
    System.out.println(addBinary("1010", "1011"));
  }

  public static String addBinary(String a, String b) {
    // Initialize result
    String result = "";

    // Initialize digit sum
    int s = 0;

    // Traverse both strings starting
    // from last characters
    int i = a.length() - 1, j = b.length() - 1;
    while (i >= 0 || j >= 0 || s == 1) {

      // Comput sum of last
      // digits and carry
      s += ((i >= 0) ? a.charAt(i) - '0' : 0);
      s += ((j >= 0) ? b.charAt(j) - '0' : 0);

      // If current digit sum is
      // 1 or 3, add 1 to result
      result = (char) (s % 2 + '0') + result;

      // Compute carry
      s /= 2;

      // Move to next digits
      i--;
      j--;
    }

    return result;
  }
}
