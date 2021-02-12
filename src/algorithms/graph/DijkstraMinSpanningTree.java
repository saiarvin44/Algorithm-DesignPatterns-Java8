package algorithms.graph;

import java.util.Arrays;

public class DijkstraMinSpanningTree {
  public int[] dijkistra(int[][] graph, int source) {
    int V = graph.length;
    int[] dist = new int[V];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[source] = 0;
    boolean[] finalized = new boolean[V];
    for (int count = 0;
        count < V - 1;
        count++) { // V-1 because when at the last but one vertex, last vertex
                   // will always have the lowest value
      int u = -1;
      for (int i = 0; i < V; i++) if (!finalized[i] && (u == -1 || dist[i] < dist[u])) u = i;
      finalized[u] = true;
      for (int v = 0; v < V; v++)
        if (!finalized[v] && graph[u][v] != 0) dist[v] = Math.min(dist[v], dist[u] + graph[u][v]);
    }
    return dist;
  }
}
