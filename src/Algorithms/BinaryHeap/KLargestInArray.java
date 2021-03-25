package Algorithms.BinaryHeap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestInArray {
  public static void main(String[] args) {
    int[] arr = new int[] {5, 15, 10, 20, 8};
    KLargest(arr, 3);
  }

  private static void KLargest(int[] arr, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 0; i < arr.length; i++) pq.add(arr[i]);
    for (int i = 0; i < k; i++) System.out.print(pq.poll() + " ");
  }
}
