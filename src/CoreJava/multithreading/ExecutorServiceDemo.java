package CoreJava.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
  public static void main(String[] args) {
    Print[] jobs = {new Print("Sai"), new Print("Arvind")};
    ExecutorService service = Executors.newFixedThreadPool(2);
    for (Print job : jobs) service.submit(job);
    service.shutdown();
  }
}

class Print implements Runnable {

  String name;

  Print(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    System.out.println("Job started by thread : " + Thread.currentThread().getName());
    try {
      Thread.sleep(5000);
    } catch (InterruptedException ie) {
    }
    System.out.println("Job completed by thread : " + Thread.currentThread().getName());
  }
}
