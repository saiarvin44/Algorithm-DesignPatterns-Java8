package CoreJava.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantTryLock extends Thread {
  static ReentrantLock lock = new ReentrantLock();

  ReentrantTryLock(String name) {
    super(name);
  }

  public void run() {
    if (lock.tryLock()) {
      System.out.println(
          Thread.currentThread().getName() + "... got lock and performing safe operation");
      try {
        Thread.sleep(2000);
      } catch (InterruptedException ie) {
      }
      lock.unlock();
    } else {
      System.out.println(
          Thread.currentThread().getName()
              + "... unable to get lock and hence performing other operations");
    }
  }
}

class ReentrantDemo {
  public static void main(String[] args) {
    ReentrantTryLock t1 = new ReentrantTryLock("first thread");
    ReentrantTryLock t2 = new ReentrantTryLock("second thread");
    t1.start();
    t2.start();
  }
}
