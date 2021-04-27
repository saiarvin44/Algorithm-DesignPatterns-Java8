package CoreJava.multithreading.Executors.ScheduledExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class SchedulesExecutorServiceDemo {
  public static void main(String[] args) {
    ScheduledExecutorService service = (ScheduledExecutorService) Executors.newFixedThreadPool(4);
  }
}
