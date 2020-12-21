package CoreJava.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterrantDemo {
  ReentrantLock lock = new ReentrantLock();

  public static void main(String[] args) {}

  public void wish(String name) {
    lock.lock();
    for (int i = 0; i < 10; i++) {
      System.out.print("Good morning : ");
      try {
        Thread.sleep(2000);
      } catch (InterruptedException ex) {
      }
      System.out.println(name);
    }
    lock.unlock();
  }
}

class ReentrantMyThread extends Thread {
  ReenterrantDemo d;
  String name;

  ReentrantMyThread(ReenterrantDemo d, String name) {
    this.d = d;
    this.name = name;
  }

  public void run() {
    d.wish(name);
  }
}

class SynchronizedDemo {
  public static void main(String[] args) {
    ReenterrantDemo d = new ReenterrantDemo();
    ReentrantMyThread myThread1 = new ReentrantMyThread(d, "Arvind");
    ReentrantMyThread myThread2 = new ReentrantMyThread(d, "Sai");
    myThread1.start();
    myThread2.start();
  }
}
