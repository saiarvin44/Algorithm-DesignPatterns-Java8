package CoreJava.multithreading.ThreadGroup;

class ThreadGroupDemo1 extends Thread {
  ThreadGroupDemo1(String a, ThreadGroup b) {
    super(b, a);
  }

  public void run() {
    for (int i = 0; i < 10; i++) {
      try {
        Thread.sleep(10);
      } catch (InterruptedException ex) {
        System.out.println(Thread.currentThread().getName());
      }
    }
    System.out.println(Thread.currentThread().getName());
  }
}

public class Demo {
  public static void main(String arg[]) throws InterruptedException, SecurityException {

    ThreadGroup obj1 = new ThreadGroup("Parent thread =====> ");
    ThreadGroup obj2 = new ThreadGroup(obj1, "child thread =====> ");
    ThreadGroupDemo1 t1 = new ThreadGroupDemo1("*******Thread-1*******", obj1);
    t1.start();
    ThreadGroupDemo1 t2 = new ThreadGroupDemo1("*******Thread-2*******", obj1);
    t2.start();
    obj1.checkAccess();
    System.out.println(obj1.getName() + " has access");
    obj2.checkAccess();
    System.out.println(obj2.getName() + " has access");
    System.out.println("Total number of active thread =====> " + obj1.activeCount());
  }
}
