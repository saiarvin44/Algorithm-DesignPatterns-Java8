package CoreJava.multithreading.basics;

public class Question1 implements Runnable {
  private String name;

  public Question1(String name) {
    this.name = name;
  }

  public static void main(String[] args) {
    new Thread(new Question1("Wallace")).start();
    new Thread(new Question1("Gromit")).start();
  }

  @Override
  public void run() {
    message(1);
    message(2);
  }

  private synchronized void message(int n) {
    System.out.print(name + "-" + n + " ");
  }
}
