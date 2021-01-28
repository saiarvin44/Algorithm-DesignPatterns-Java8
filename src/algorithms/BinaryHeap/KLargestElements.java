package algorithms.BinaryHeap;

import java.util.Iterator;
import java.util.PriorityQueue;

public class KLargestElements {
  public static void main(String[] args) {
    PriorityQueue<Integer> ans = kLargest(new int[] {5, 15, 10, 20, 8, 25, 18}, 3);
    Iterator value = ans.iterator();
    while (value.hasNext()) System.out.print(value.next() + " ");
  }

  private static PriorityQueue<Integer> kLargest(int[] arr, int k) {
    PriorityQueue<Integer> q = new PriorityQueue<>();
    for (int i = 0; i < k; i++) q.add(arr[i]);
    for (int i = 3; i < arr.length; i++)
      if (q.peek() < arr[i]) {
        q.poll();
        q.add(arr[i]);
      }
    return q;
  }
}
