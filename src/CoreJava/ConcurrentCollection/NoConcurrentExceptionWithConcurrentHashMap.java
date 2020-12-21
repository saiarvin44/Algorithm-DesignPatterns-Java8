package CoreJava.ConcurrentCollection;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class NoConcurrentExceptionWithConcurrentHashMap extends Thread {
  static ConcurrentHashMap m = new ConcurrentHashMap();

  public static void main(String[] args) throws InterruptedException {
    m.put(101, "a");
    m.put(102, "b");
    NoConcurrentExceptionWithConcurrentHashMap t = new NoConcurrentExceptionWithConcurrentHashMap();
    t.start();
    Set s = m.keySet();
    Iterator it = s.iterator();
    while (it.hasNext()) {
      Integer i = (Integer) it.next();
      System.out.println(
          "Main thread iterating map and current entry is : " + i + "..." + m.get(i));
      Thread.sleep(3000);
    }
    System.out.println(m);
  }

  public void run() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException ie) {
    }
    System.out.println("Child thread updating map");
    m.put(103, "c");
  }
}
