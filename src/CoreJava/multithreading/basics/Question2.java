package CoreJava.multithreading.basics;

public class Question2 {
  public static void main(String[] args) {
    System.out.print("1 ");
    synchronized (args) {
      System.out.println("2 ");
      try {
        args.wait();
      } catch (InterruptedException e) {
      }
    }
    System.out.print("3 ");
  }
}
