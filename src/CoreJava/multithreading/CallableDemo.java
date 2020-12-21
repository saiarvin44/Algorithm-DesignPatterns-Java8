package CoreJava.multithreading;

import java.util.concurrent.*;

public class CallableDemo implements Callable {
  int num;

  CallableDemo(int num) {
    this.num = num;
  }

  @Override
  public Object call() throws Exception {
    System.out.println(
        Thread.currentThread().getName()
            + "... is responsible to find sum of first "
            + num
            + " numbers");
    int sum = 0;
    for (int i = 1; i <= num; i++) sum = sum + i;
    return sum;
  }
}

class CallableFutureDemo {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    CallableDemo[] jobs = {
      new CallableDemo(10), new CallableDemo(20), new CallableDemo(30), new CallableDemo(40)
    };

    ExecutorService service = Executors.newFixedThreadPool(3);
    for (CallableDemo job : jobs) {
      Future f = service.submit(job);
      System.out.println(f.get());
    }
    service.shutdown();
  }
}
