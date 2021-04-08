package Algorithms.leetcodeAlgos.easy;

import java.util.*;
import java.util.stream.IntStream;

public class lastStoneWeight {
  public static void main(String[] args) {
    System.out.print(lastStoneWeight(new int[] {2,2}));
  }

  public static int lastStoneWeight(int[] stones) {
    List<Integer> list =
        new ArrayList(Arrays.asList(IntStream.of(stones).boxed().toArray(Integer[]::new)));
    Collections.sort(list, Collections.reverseOrder());
    PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 0; i < list.size(); i++) q.add(list.get(i));
    while (q.size() >= 2) {
      int a = q.poll();
      int b = q.poll();
      if ((a - b) != 0) q.add(a - b);
    }
    if(!q.isEmpty())
      return q.peek();
    return -1;
  }
}
