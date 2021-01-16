package CoreJava.strings;

public class StringBuilderDemo {
  public static void main(String[] args) {
      StringBuilder builder=new StringBuilder("");
      builder.append('a');
      builder.append('b');
      System.out.print(builder.toString());
  }
}
