package algorithms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class IslandsInAGraphOrNoOfConnectedComponents {
  public void BFS(ArrayList<ArrayList<Integer>> adj, int V, int s, boolean[] visited) {
    Queue<Integer> q = new LinkedList<>();
    visited[s] = true;
    q.add(s);
    while (q.isEmpty() == false) {
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

  public int BFSDis(ArrayList<ArrayList<Integer>> adj, int v) {
    boolean[] visited = new boolean[v + 1];
    int count = 0;
    for (int i = 0; i < v; i++)
      if (visited[i] == false) {
        BFS(adj, v, i, visited);
        count++;
      }
    return count;
  }
}
