package algorithms.BinarySearchTree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewAndBottomView {
  void topView(Node root) {
    Queue<VerticalTraversal.Pair> q = new LinkedList<>();
    Map<Integer, Integer> map = new TreeMap<>();
    q.add(new VerticalTraversal.Pair(root, 0));
    while (!q.isEmpty()) {
      VerticalTraversal.Pair p = q.poll();
      Node curr = p.node;
      Integer hd = p.horizontalDistance;
      if (!map.containsKey(hd)) map.put(hd, curr.key);
      if (curr.left != null) q.add(new VerticalTraversal.Pair(curr.left, hd - 1));
      if (curr.right != null) q.add(new VerticalTraversal.Pair(curr.right, hd + 1));
    }
  }

  void bottomView(Node root) {
    Queue<VerticalTraversal.Pair> q = new LinkedList<>();
    Map<Integer, Integer> map = new TreeMap<>();
    q.add(new VerticalTraversal.Pair(root, 0));
    while (!q.isEmpty()) {
      VerticalTraversal.Pair p = q.poll();
      Node curr = p.node;
      Integer hd = p.horizontalDistance;
      map.put(
          hd,
          curr.key); // replace the existing value with the current value, as it comes in the bottom
      // side
      if (curr.left != null) q.add(new VerticalTraversal.Pair(curr.left, hd - 1));
      if (curr.right != null) q.add(new VerticalTraversal.Pair(curr.right, hd + 1));
    }
  }
}
