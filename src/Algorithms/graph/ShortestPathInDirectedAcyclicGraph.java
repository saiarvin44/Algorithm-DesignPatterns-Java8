package Algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestPathInDirectedAcyclicGraph {
  // s is the index of the begining node
  public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int s, int v) {
    int[] dist = new int[v];
    int[] TPS = new int[v];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[0] = 0;
    topologicalSort(adj, TPS, v);
    for (int vertex : TPS)
      for (int adjacent : adj.get(vertex))
        if (dist[adjacent] > dist[vertex] + weigth(vertex, adjacent))
          dist[adjacent] = dist[vertex] + weigth(vertex, adjacent);
    return dist;
  }

  private int weigth(int vertex, int adjacent) {
    // returns the weight of edge between vertex and adjacent (customize it) : right now it is dummy logic
    return Math.max(vertex, adjacent);
  }

  private void topologicalSort(ArrayList<ArrayList<Integer>> adj, int[] tps, int v) {
    boolean[] visited = new boolean[v];
    Stack<Integer> stack = new Stack<>();
    for (int s = 0; s < v; s++) if (!visited[s]) DFSRec(adj, visited, s, stack);
    for (int i = 0; i < v; i++) if (!stack.isEmpty()) tps[i] = stack.pop();
  }

  private void DFSRec(
      ArrayList<ArrayList<Integer>> adj, boolean[] visited, int start, Stack<Integer> stack) {
    visited[start] = true;
    for (int elt : adj.get(start)) if (!visited[elt]) DFSRec(adj, visited, elt, stack);
    stack.push(start);
  }
}
