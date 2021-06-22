package CoreJava.Exception;

public class Exec0 extends Exception {}

class Exec1 extends Exec0 {}

class Test {
  public static void main(String[] args) {
    try {
      throw new Exec1();
    } catch (Exec0 e0) {
      System.out.print("Exec0 caught");
    } catch (Exception e) {
      System.out.print("Exec caught");
    }
  }
}
