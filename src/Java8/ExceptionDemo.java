package Java8;

public class ExceptionDemo {
  public static void main(String[] args) {
    try {
      System.out.print(1 / 0);
    } catch (ArithmeticException e) {
      throw new RuntimeException("runtime exception", e);
    }
  }
}
