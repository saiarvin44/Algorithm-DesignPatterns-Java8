package Algorithms.graph;

import java.util.ArrayList;

public class DFSOfDisconnectedGraph {
     void DFS(ArrayList<ArrayList<Integer>> adj, int V){
         boolean visited[] = new boolean[V];
         for(int i=0;i<V;i++)
             if(visited[i]==false)
                 DFSRec(adj,i,visited);
     }

    private void DFSRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
         visited[s]=true;
         System.out.print(s+" ");
         for(int u:adj.get(s))
             if(visited[u]==false)
                 DFSRec(adj,s,visited);
    }
}
