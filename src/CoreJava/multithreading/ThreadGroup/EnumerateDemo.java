package CoreJava.multithreading.ThreadGroup;

class Demo2 extends Thread {
  Demo2(String a, ThreadGroup b) {
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
    System.out.println(Thread.currentThread().getName() + " =====> completed executing");
  }
}

class ThreadDemo2 {
  public static void main(String arg[]) {
    ThreadGroup o1 = new ThreadGroup("*****parent thread group*****");
    ThreadGroup o2 = new ThreadGroup(o1, "*****Child thread group*****");
    System.out.println("Maximum priority of Child Thread: " + o2.getMaxPriority());

    Demo2 obj1 = new Demo2("*****Thread 1*****", o1);
    System.out.println("Thread 1 Starts");
    obj1.start();
    Demo2 obj2 = new Demo2("*****Thread 2*****", o1);
    System.out.println("Thread 2 Starts");
    obj2.start();

    Thread[] tarray = new Thread[o1.activeCount()];
    int count1 = o1.enumerate(tarray);

    for (int i = 0; i < count1; i++) System.out.println(tarray[i].getName() + " =====> Found");
  }
}
