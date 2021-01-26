package algorithms.BinaryHeap;

import java.util.PriorityQueue;

public class PriorityQueueClass {
  public static void main(String[] args) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.add(10);
    pq.add(20);
    pq.add(15);
    System.out.println(pq.peek());
    System.out.println(pq.poll());
    System.out.println(pq.peek());
  }
}
