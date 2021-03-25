package Algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class DetectCyclesInUndirectedGraph {

  public static boolean checkCycle(ArrayList<ArrayList<Integer>> adj, int v) {
    boolean[] visited = new boolean[v];
    Arrays.fill(visited, false);
    for (int i = 0; i < v; i++)
      if (visited[i] == false) if (DFSRec(adj, i, visited, -1) == true) return true;
    return false;
  }

  private static boolean DFSRec(
      ArrayList<ArrayList<Integer>> adj, int start, boolean[] visited, int parent) {
    visited[start] = true;
    for (int v : adj.get(start)) {
      if (visited[v] == false)
        if (DFSRec(adj, v, visited, start) == true) return true;
        else if (v != parent) return true;
    }
    return false;
  }
}
