package algorithms.BinaryHeap;

import java.util.PriorityQueue;

public class KSortedArray {
  public static void main(String[] args) {
    int[] arr = new int[] {9, 8, 7, 18, 19, 17};
    int k = 2;
    kSort(arr, 2);
  }

  private static void kSort(int[] arr, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i <= k; i++) pq.add(arr[i]);
    int index = 0;
    for (int i = k + 1; i < arr.length; i++) {
      arr[index++] = pq.poll();
      pq.add(arr[i]);
    }
    while (pq.isEmpty() == false) arr[index++] = pq.poll();
  }
}
