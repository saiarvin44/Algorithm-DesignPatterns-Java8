package CoreJava.multithreading.basics;

class ClassForSync {}

public class SynchronizedBlock2 extends Thread {
  ClassForSync syncClass;

  public SynchronizedBlock2(ClassForSync syncClass) {
    this.syncClass = syncClass;
  }

  @Override
  public void run() {
    synchronized (ClassForSync.class) {
      System.out.println(
          "Got lock of ClassForSync class by thread " + Thread.currentThread().getName());
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Released lock by " + Thread.currentThread().getName());
    }
  }
}

class demo {
  public static void main(String[] args) {
    ClassForSync sync = new ClassForSync();
    SynchronizedBlock2 thread1 = new SynchronizedBlock2(sync);
    SynchronizedBlock2 thread2 = new SynchronizedBlock2(sync);
    thread1.start();
    thread2.start();
  }
}
