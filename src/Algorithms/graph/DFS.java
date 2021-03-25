package Algorithms.graph;

import java.util.ArrayList;

public class DFS {
  public static void main(String[] args) {}

  void DFSRec(ArrayList<ArrayList<Integer>> adj, int S, boolean[] visited) {
    visited[S] = true;
    System.out.print(S + " ");
    for (int u : adj.get(S)) if (visited[u] == false) DFSRec(adj, u, visited);
  }

  void DFS(ArrayList<ArrayList<Integer>> adj, int V, int s) {
    boolean[] visited = new boolean[V];
    DFSRec(adj, s, visited);
  }
}
