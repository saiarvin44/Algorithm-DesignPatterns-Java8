package DesignPatterns.LowLevelDesign.Calculator;

import java.util.regex.Pattern;

public class Constants {
  public static final char leftP = '(';
  public static final char rightP = ')';
  public static final char add = '+';
  public static final char equalTo = '=';
  public static final char subtract = '-';
  public static final char multiply = '*';
  public static final char divide = '/';
  private static int leftPCount = 0, rightPCount = 0;
  public static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

  public static boolean commonIsEnableRightP(StringBuilder builder) {
    String curr = builder.toString();
    char lastChar = curr.charAt(curr.length() - 1);
    for (int i = 0; i < curr.length(); i++) {
      if (curr.charAt(i) == '(') leftPCount++;
      if (curr.charAt(i) == ')') rightPCount++;
    }
    if ((commonIsNumber(builder) || lastChar == ')') && leftPCount > rightPCount)
      return true;
    return false;
  }

  public static boolean commonIsNumber(StringBuilder builder) {
    String curr = builder.toString();
    char lastChar = curr.charAt(curr.length() - 1);
    if (pattern.matcher(Character.toString((lastChar))).matches())
      return true;
    return false;
  }
}
