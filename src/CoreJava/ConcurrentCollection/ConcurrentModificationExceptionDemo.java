package CoreJava.ConcurrentCollection;

import java.util.ArrayList;
import java.util.Iterator;

public class ConcurrentModificationExceptionDemo extends Thread {
  static ArrayList l = new ArrayList();

  public static void main(String[] args) throws InterruptedException {
    l.add("A");
    l.add("B");
    l.add("C");
    ConcurrentModificationExceptionDemo t = new ConcurrentModificationExceptionDemo();
    t.start();
    Iterator it = l.iterator();
    while (it.hasNext()) {
      String s = (String) it.next();
      System.out.println("Main thread iterating list and child thread trying to update values");
      Thread.sleep(3000);
    }
    System.out.println(l);
  }

  public void run() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException ie) {
    }
    System.out.println("Child thread updating list");
    l.add("D");
  }
}
