package CoreJava.multithreading.basics;

public class GCOutput {
  static GCOutput gcOutput;
  static int count = 0;

  public static void main(String[] args) throws InterruptedException {
    GCOutput gcOutput = new GCOutput();
    gcOutput = null;
    System.gc();
    Thread.sleep(1000);
    gcOutput = null;
    System.gc();
    Thread.sleep(1000);
    System.out.print("Finalize method called " + count + " times");
  }

  @Override
  protected void finalize() throws Throwable {
    count++;
    gcOutput = this;
  }
}
