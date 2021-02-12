package algorithms.graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortingDFS {
  public void topologicalSort(ArrayList<ArrayList<Integer>> adj, int V) {
    Stack<Integer> s = new Stack<>();
    boolean[] visited = new boolean[V];
    for (int start = 0; start < V; start++)
      if (!visited[start]) DFSForTopologicalSort(adj, start, s, visited);
    while (!s.isEmpty()) System.out.print(s.pop() + " ");
  }

  private void DFSForTopologicalSort(
      ArrayList<ArrayList<Integer>> adj, int start, Stack<Integer> s, boolean[] visited) {
    visited[start] = true;
    for (int u : adj.get(start)) if (!visited[u]) DFSForTopologicalSort(adj, u, s, visited);
    s.push(start);
  }
}
