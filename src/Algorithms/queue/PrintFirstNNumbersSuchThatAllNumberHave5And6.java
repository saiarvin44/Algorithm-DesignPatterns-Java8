package Algorithms.queue;

import java.util.LinkedList;
import java.util.Queue;

public class PrintFirstNNumbersSuchThatAllNumberHave5And6 {
  public static void main(String[] args) {
    int n = 10;
    printFirstN(n);
  }

  private static void printFirstN(int n) {
    Queue<String> q = new LinkedList<>();
    q.offer("5");
    q.offer("6");
    for (int count = 0; count < n; count++) {
      String curr = q.poll();
      System.out.print(curr + " ");
      q.offer(curr + "5");
      q.offer(curr + "6");
    }
  }
}
