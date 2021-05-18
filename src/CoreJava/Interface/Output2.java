package CoreJava.Interface;

public final class Output2 {
  private boolean flag = true;

  public Output2() {
    (new Inner()).test();
  }

  public static void main(String[] args) {
    new Output2();
  }

  private void sample() {
    System.out.println("Sample");
  }

  class Inner {
    void test() {
      if (Output2.this.flag) sample();
    }
  }
}
