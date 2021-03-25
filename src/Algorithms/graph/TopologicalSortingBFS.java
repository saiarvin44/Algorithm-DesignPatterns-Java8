package Algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortingBFS {
  public void topologicalSort(ArrayList<ArrayList<Integer>> adj, int v) {
    int[] indegree = new int[v];
    Queue<Integer> q = new LinkedList<>();
    Arrays.fill(indegree, 0);
    for (int i = 0; i < v; i++) for (int j : adj.get(i)) indegree[j]++;
    for (int i = 0; i < indegree.length; i++) if (indegree[i] == 0) q.add(i);
    while (!q.isEmpty()) {
      int u = q.poll();
      System.out.print(u + " ");
      for (int i : adj.get(u)) {
        indegree[i]--;
        if (indegree[i] == 0) q.add(i);
      }
    }
  }
}
