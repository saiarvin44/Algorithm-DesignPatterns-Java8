package Algorithms.queue;

import java.util.Queue;

public class StackUsingQueue {
  Queue<Integer> q1, q2;

  int top() {
    return q1.peek();
  }

  int size() {
    return q1.size();
  }

  int pop() {
    return q1.poll();
  }

  void push(int x) {
    while (!q1.isEmpty()) q2.offer(q1.poll());
    q1.offer(x);
    while (!q2.isEmpty()) q1.offer(q2.poll());
  }
}
