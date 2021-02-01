package CoreJava.strings.regex;

import java.util.Collections;

public class Demo {
  public static void main(String[] args) {
    String text = "This is a sample text    , lets see how it works out   .";
    String pattern = "(\\w)(\\s+)([\\.,])";

    System.out.println(text.replaceAll(pattern, "$1$3"));
  }
}
