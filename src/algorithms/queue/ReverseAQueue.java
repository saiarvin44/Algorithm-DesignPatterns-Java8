package algorithms.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseAQueue {
  public static void main(String[] args) {
    Queue<Integer> q = new ArrayDeque<>();
    q.offer(1);
    q.offer(2);
    q.offer(3);
    q.offer(4);
    q.offer(5);
    reverse(q);
    reverseRecursive(q);
    for (Integer elt : q) System.out.print(q.poll() + " ");
  }

  private static void reverseRecursive(Queue<Integer> q) {
    if(q.isEmpty())
      return;
    int x=q.poll();
    reverseRecursive(q);
    q.offer(x);

  }

  private static void reverse(Queue<Integer> q) {
    Stack<Integer> s = new Stack<>();
    while (!q.isEmpty()) s.push(q.remove());
    while (!s.isEmpty()) q.offer(s.pop());
  }
}
