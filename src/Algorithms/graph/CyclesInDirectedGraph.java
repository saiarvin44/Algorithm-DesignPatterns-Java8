package Algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class CyclesInDirectedGraph {
  public static void main(String[] args) {}

  public boolean DFS(ArrayList<ArrayList<Integer>> adj, int V) {
    boolean[] visited = new boolean[V];
    boolean[] recStack = new boolean[V];
    Arrays.fill(visited, false);
    Arrays.fill(recStack, false);

    for (int i = 0; i < V; i++)
      if (visited[i] == false) if (DFSrec(adj, i, visited, recStack)) return true;
    return false;
  }

  private boolean DFSrec(
      ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, boolean[] recStack) {
    visited[s] = true;
    recStack[s] = true;
    for (int v : adj.get(s)) {
      if (visited[v] == false && DFSrec(adj, v, visited, recStack)) return true;
      else if (recStack[v] == true) return true;
    }
    recStack[s] = false;
    return false;
  }
}
