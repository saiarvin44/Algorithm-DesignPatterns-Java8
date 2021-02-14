package CoreJava.collections.leetcodeAlgos;

import algorithms.BinarySearchTree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
  public List<Double> averageOfLevels(Node root) {
    if (root == null) return null;
    List<Double> list = new ArrayList<>();
    Queue<Node> q = new LinkedList<>();
    if (root.left == null && root.right == null) {
      list.add(Double.valueOf(root.key));
      return list;
    }
    Double add;
    q.add(root);
    while (!q.isEmpty()) {
      int count = 0;
      add = 0.0;
      Queue<Node> temp = new LinkedList<>();
      while (!q.isEmpty()) {
        Node n = q.poll();
        add += Double.valueOf(n.key);
        count++;
        if (n.left != null) temp.add(n.left);
        if (n.right != null) temp.add(n.right);
      }
      q = temp;
      list.add(add / count);
    }
    return list;
  }
}
