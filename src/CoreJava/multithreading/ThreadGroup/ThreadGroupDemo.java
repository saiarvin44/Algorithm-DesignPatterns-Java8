package CoreJava.multithreading.ThreadGroup;

public class ThreadGroupDemo {
  public static void main(String[] args) {
    ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
    Thread[] threads = new Thread[system.activeCount()];
    system.enumerate(threads);
    for (Thread t : threads) System.out.println(t.getName() + " is daemon ? : " + t.isDaemon());
  }
}
