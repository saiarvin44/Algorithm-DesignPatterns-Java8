package CoreJava.strings;

public class IntegerParse {
  public static void main(String[] args) {
    System.out.print(myAtoi("-5-"));
  }

  public static int myAtoi(String s) {
    int ans = 0, i, j;
    s = s.trim();
    if (s.length() == 0) return 0;
    if (!((s.charAt(0) >= '0' && s.charAt(0) <= '9')
        || (s.charAt(0) == '-')
        || (s.charAt(0) == '+'))) return 0;
    try {
      ans = Integer.parseInt(s);
    } catch (NumberFormatException e) {
      for (i = 0; i < s.length(); i++) {
        if (!((s.charAt(i) >= '0' && s.charAt(i) <= '9') || (s.charAt(i) == '-'))) break;
      }
      char[] charArray = new char[i];
      for (j = 0; j < i; j++) charArray[j] = s.charAt(j);
      s = new String(charArray);
      try {
        ans = Integer.parseInt(s);
        return ans;
      } catch (NumberFormatException ex) {
        double doubleAns = 0;
        try {
          doubleAns = Double.parseDouble(s);
          if (doubleAns != 0) {
            if (s.charAt(0) == '-') return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
          }
        } catch (NumberFormatException ex2) {
          return 0;
        }
      }
    }
    return ans;
  }
}
