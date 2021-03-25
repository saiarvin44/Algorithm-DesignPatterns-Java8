package Algorithms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
  void BFS(ArrayList<ArrayList<Integer>> adj, int V, int s) {
    boolean[] visited = new boolean[V + 1];
    Queue<Integer> q = new LinkedList<>();
    q.add(s);
    visited[s] = true;
    while (!q.isEmpty()) {
      int u = q.poll();
      System.out.print(u + " ");
      for (int v : adj.get(u)) {
        if (visited[v] == false) {
          visited[v] = true;
          q.add(v);
        }
      }
    }
  }
}
