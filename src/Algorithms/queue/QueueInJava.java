package Algorithms.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueInJava {
  public static void main(String[] args) {
    Queue<Integer> q = new ArrayDeque<>();
    q.offer(10);
    q.offer(20);
    q.offer(30);
    for (Integer elt : q) System.out.print(elt + " ");
    System.out.println("Peek first elt : " + q.peek());
    System.out.println("Remove first elt : " + q.poll());
    System.out.println("Peek first elt : " + q.peek());
  }
}
