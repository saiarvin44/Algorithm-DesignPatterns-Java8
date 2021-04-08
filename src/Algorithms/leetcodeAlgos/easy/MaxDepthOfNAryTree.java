package Algorithms.leetcodeAlgos.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class MaxDepthOfNAryTree {
  int maxLen = 0;

  public int another(Node root) {
    if (root == null) return 0;
    int len = 0;
    Queue<Node> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      int size = q.size();
      len++;
      for (int i = 0; i < size; i++) {
        Node t = q.poll();
        for (Node child : t.children) q.offer(child);
      }
    }

    return len;
  }

  public int maxDepth(Node root) {
    maxLen = 0;
    if (root == null) return 0;
    for (Node child : root.children) maxLen = Math.max(maxLen, maxDepth(child));
    return maxLen + 1;
  }

  class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }
}
