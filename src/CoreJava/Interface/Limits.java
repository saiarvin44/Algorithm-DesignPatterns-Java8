package CoreJava.Interface;

public class Limits {
  protected static int x2 = 5;
  private static int x1 = 4;
  protected int y = 3;
  private int x = 2;

  public static void main(String[] args) {
    int x = 6;
    int y = 7;
    int x1 = 8;
    int x2 = 9;
    new Limits().new Secret().go();
  }

  class Secret {
    void go() {
      System.out.print(x + " " + y + " " + x1 + " " + x2);
    }
  }
}
