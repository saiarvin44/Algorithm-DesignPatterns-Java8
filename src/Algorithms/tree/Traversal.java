package Algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traversal {

  int maxLevel = 0; // to keep track of max level, define it at class level

  void inOrder(Representation root) {
    if (root != null) {
      inOrder(root.left);
      System.out.print(root.key + " ");
      inOrder(root.right);
    }
  }

  void preorder(Representation root) {
    if (root != null) {
      System.out.print(root.key + " ");
      preorder(root.left);
      preorder(root.right);
    }
  }

  void postorder(Representation root) {
    if (root != null) {
      postorder(root.left);
      postorder(root.right);
      System.out.print(root.key + " ");
    }
  }

  int height(Representation root) {
    if (root == null) return 0;
    else return Math.max(height(root.left), height(root.right)) + 1;
  }

  void printNodesAtDistanceK(Representation root, int k) { // print the kth level elemenets
    if (root == null) return;
    if (k == 0) System.out.print(root.key + " ");
    else {
      printNodesAtDistanceK(root.left, k - 1);
      printNodesAtDistanceK(root.right, k - 1);
    }
  }

  void levelOrderTraversal(Representation root) { // or BFS
    if (root == null) return;
    Queue<Representation> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      Representation curr = q.poll();
      System.out.print(curr.key + " ");
      if (curr.left != null) q.add(curr.left);
      if (curr.right != null) q.add(curr.right);
    }
  }

  void levelOrderTraversalLineByLine(Representation root) {
    if (root == null) return;
    Queue<Representation> q = new LinkedList<>();
    q.add(root);
    q.add(null);
    while (q.size() > 1) {
      Representation curr = q.poll();
      if (curr == null) {
        System.out.println();
        q.add(null);
        continue;
      }
      System.out.print(curr.key + " ");
      if (curr.left != null) q.add(curr.left);
      if (curr.right != null) q.add(curr.right);
    }
  }

  void levelOrderTraversalLineByLineAnother(Representation root) {
    if (root == null) return;
    Queue<Representation> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      int count = q.size();
      for (int i = 0; i < count; i++) {
        Representation curr = q.poll();
        if (curr == null) {
          System.out.println();
          q.add(null);
          continue;
        }
        System.out.print(curr.key + " ");
        if (curr.left != null) q.add(curr.left);
        if (curr.right != null) q.add(curr.right);
      }
      System.out.println();
    }
  }

  int size(Representation root) {
    if (root == null) return 0;
    else return 1 + size(root.left) + size(root.right);
  }

  int maximumInBinaryTree(Representation root) {
    if (root == null) return Integer.MIN_VALUE;
    else
      return Math.max(
          root.key, Math.max(maximumInBinaryTree(root.left), maximumInBinaryTree(root.right)));
  }

  void leftViewOfBinaryTree(
      Representation root, int level) { // level of the current node, initially pass as 1
    if (root == null) return;
    if (maxLevel < level) { // print it because this is the first node of this level
      System.out.print(root.key + " ");
      maxLevel = level;
    }
    leftViewOfBinaryTree(root.left, level + 1);
    leftViewOfBinaryTree(root.right, level + 1);
  }

  void leftViewOfBinaryTreeAnother(Representation root) {
    if (root == null) return;
    Queue<Representation> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      int count = q.size();
      for (int i = 0; i < count; i++) {
        Representation curr = q.poll();
        if (i == 0) System.out.print(curr.key + " ");
        if (curr.left != null) q.add(curr.left);
        if (curr.right != null) q.add(curr.right);
      }
    }
  }

  boolean childrenSumProperty(Representation root) {
    if (root == null) return true;
    if (root.left == null && root.right == null) return true;
    int sum = 0;
    if (root.left != null) sum += root.left.key;
    if (root.right != null) sum += root.right.key;
    return (root.key == sum && childrenSumProperty(root.left) && childrenSumProperty(root.right));
  }

  boolean balancedTree(
      Representation root) { // diff between left sub tree and right tree height should be max 1
    if (root == null) return true;
    int lh = height(root.left);
    int rh = height(root.right);
    return (Math.abs(lh - rh) <= 1 && balancedTree(root.left) && balancedTree(root.right));
  }

  int balancedTreeAgain(Representation root) {
    if (root == null) return 0;
    int lh = balancedTreeAgain(root.left);
    if (lh == -1) return -1;
    int rh = balancedTreeAgain(root.right);
    if (rh == -1) return -1;
    if (Math.abs(lh - rh) > 1) return -1;
    else return Math.max(lh, rh) + 1;
  }

  int maxWidth(Representation root) {
    if (root == null) return 0;
    Queue<Representation> q = new LinkedList<>();
    q.add(root);
    int res = 0;
    while (!q.isEmpty()) {
      int count = q.size();
      res = Math.max(res, count);
      for (int i = 0; i < count; i++) {
        Representation curr = q.poll();
        if (curr.left != null) q.add(curr.left);
        if (curr.right != null) q.add(curr.right);
      }
    }
    return res;
  }

  void levelOrderTraversalInSpiralForm(Representation root) {
    if (root == null) return;
    Queue<Representation> q = new LinkedList<>();
    Stack<Integer> s = new Stack<>();
    boolean reverse = false;
    q.add(root);
    while (!q.isEmpty()) {
      int count = q.size();
      for (int i = 0; i < count; i++) {
        Representation curr = q.poll();
        if (reverse) s.push(curr.key);
        else System.out.print(curr.key + " ");
        if (curr.left != null) q.add(curr.left);
        if (curr.right != null) q.add(curr.right);
        if (reverse) {
          while (!s.isEmpty()) System.out.print(s.pop() + " ");
        }
        reverse = !reverse;
      }
    }
  }

  int diameter(Representation root) {
    if (root == null) return 0;
    int d1 = 1 + height(root.left) + height(root.right);
    int d2 = diameter(root.left);
    int d3 = diameter(root.right);
    return Math.max(d1, Math.max(d2, d3));
  }


  int diameter = 0;
  int diameterEfficient(Representation root) {
    if (root == null) return 0;
    int lh = diameterEfficient(root.left);
    int rh = diameterEfficient(root.right);
    diameter = Math.max(diameter, 1 + lh + rh);
    return 1 + Math.max(lh, rh);
  }
}
