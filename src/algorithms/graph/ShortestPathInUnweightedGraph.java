package algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUnweightedGraph {
  public static void main(String[] args) {}

  void shortestPathArray(ArrayList<ArrayList<Integer>> adj, int v, int s) {
    int[] dist = new int[v];
    Arrays.fill(dist, Integer.MAX_VALUE);
    Queue<Integer> q = new LinkedList<>();
    boolean[] visited = new boolean[v];
    Arrays.fill(visited, false);
    q.add(s);
    visited[s] = true;
    while (!q.isEmpty()) {
      int u = q.poll();
      for (int elt : adj.get(u)) {
        if (visited[elt] == false) {
          dist[elt] = dist[u] + 1;
          visited[elt] = true;
          q.add(elt);
        }
      }
    }
    for (int i = 0; i < dist.length; i++) System.out.print(dist[i] + " ");
  }
}
