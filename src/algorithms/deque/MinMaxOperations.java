package algorithms.deque;

import java.util.Deque;
import java.util.LinkedList;

public class MinMaxOperations {
  Deque<Integer> dq;

  MinMaxOperations() {
    dq = new LinkedList<Integer>();
  }

  void insertMin(int x) {
    dq.offerFirst(x);
  }

  void insertMax(int x) {
    dq.offerLast(x);
  }

  int getMin() {
    return dq.peekFirst();
  }

  int getMax() {
    return dq.peekLast();
  }

  int extractMin() {
    return dq.pollFirst();
  }

  int extractMax() {
    return dq.pollLast();
  }
}
