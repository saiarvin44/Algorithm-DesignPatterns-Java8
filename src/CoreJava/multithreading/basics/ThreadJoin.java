package CoreJava.multithreading.basics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThreadJoin extends Thread {
  public int processingCount = 0;

  ThreadJoin(int processingCount) {
    this.processingCount = processingCount;
    System.out.println("Thread Created");
  }

  @Override
  public void run() {
    System.out.println("Thread " + this.getName() + " started");
    while (processingCount > 0) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.out.println("Thread " + this.getName() + " interrupted");
      }
      processingCount--;
    }
    System.out.println("Thread " + this.getName() + " exiting");
  }
}

class Demo {
  @Test
  public void givenStartedThread_whenJoinCalled_waitsTillCompletion() throws InterruptedException {
    Thread t2 = new ThreadJoin(1);
    t2.start();
    System.out.println("Invoking join");
    t2.join();
    System.out.println("Returned from join");
    assertFalse(t2.isAlive());
  }

  @Test
  public void givenStartedThread_whenTimedJoinCalled_waitsUntilTimedout()
      throws InterruptedException {
    Thread t3 = new ThreadJoin(10);
    t3.start();
    t3.join(1000);
    assertTrue(t3.isAlive());
  }
}
