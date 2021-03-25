package Algorithms.strings;

public class ZigZagString {

  public static void main(String[] args) {
    String s = "ABC";
    System.out.println(convert(s, 2));
  }

  private static String convert(String s, int numRows) {
    char[] str = new char[s.length()];
    int col = s.length() / numRows, j = 0, next = 0, k = 0;
    int rowsInLastCol = s.length() % numRows;
    int diagonal = numRows - 2;
    for (k = 0; k < numRows; k++) {
      str[j++] = s.charAt(k);
      for (int i = 0; i < col - 1; i++) {
        if (k == 0) {
          next += numRows + diagonal;
          if (next < s.length()) str[j++] = s.charAt(next);
        } else if (k == numRows - 1) {
          if (i == 0) next += numRows + diagonal + k;
          else next += numRows + diagonal;
          if (next < s.length()) str[j++] = s.charAt(next);
        } else {
          if (next == 0) next += numRows + diagonal + k;
          else next += numRows + diagonal;
          j++;
          if (next < s.length()) {
            str[j] = s.charAt(next);
            if (next - k - k < s.length()) str[--j] = s.charAt(next - k - k);
          } else {
            next -= (next + 1 - s.length());
            str[--j] = s.charAt(next - rowsInLastCol + 1 - k);
            j--;
          }
          j += 2;
        }
      }
      next = 0;
    }
    return new String(str);
  }
}
