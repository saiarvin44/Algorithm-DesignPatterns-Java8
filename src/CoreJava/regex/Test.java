package CoreJava.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
  public static void main(String[] args) {
    String regex = "\\(\\w+\\)/g";
    Pattern pattern = Pattern.compile(regex);
    String data = "(name)is(age)yearsold";
    Matcher matcher = pattern.matcher(data);
    if (matcher.find()) {
      System.out.println(matcher.group(0));
    }
  }
}
