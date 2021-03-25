package Algorithms.BinarySearchTree;

import java.util.*;

public class VerticalTraversal {
  void verticalOrder(Node root) {
    Queue<Pair> q = new LinkedList<>();
    Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
    q.add(new Pair(root, 0));
    while (!q.isEmpty()) {
      Pair p = q.poll();
      Node curr = p.node;
      int hd = p.horizontalDistance;
      if (map.containsKey(hd)) map.get(hd).add(curr.key);
      else {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(curr.key);
        map.put(hd, al);
      }
      if (curr.left != null) q.add(new Pair(curr.left, hd - 1));
      if (curr.right != null) q.add(new Pair(curr.right, hd + 1));
    }
  }

  static class Pair {
    Node node;
    int horizontalDistance;

    public Pair(Node node, int horizontalDistance) {
      this.node = node;
      this.horizontalDistance = horizontalDistance;
    }
  }
}
