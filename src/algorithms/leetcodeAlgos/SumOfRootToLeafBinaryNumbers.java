package algorithms.leetcodeAlgos;

import algorithms.BinarySearchTree.Node;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfRootToLeafBinaryNumbers {
  public static void main(String[] args) {}

  public int sum(Node root) {
    int rootToLeaf = 0, curr = 0;
    Deque<Pair> stack = new ArrayDeque<>();
    stack.push(new Pair(root, 0));
    while (!stack.isEmpty()) {
      Pair p = stack.pop();
      root = p.node;
      curr = p.curr;
      if (root != null) {
        curr = (curr << 1) | root.key;
        if (root.left == null && root.right == null) rootToLeaf += curr;
        else {
          stack.push(new Pair(root.right, curr));
          stack.push(new Pair(root.left, curr));
        }
      }
    }
    return rootToLeaf;
  }

  public void preorder(Node r, int currNumber, int rootToLeaf) {
    if (r != null) {
      currNumber = (currNumber << 1) | r.key;
      // if it's a leaf, update root-to-leaf sum
      if (r.left == null && r.right == null) {
        rootToLeaf += currNumber;
      }
      preorder(r.left, currNumber, rootToLeaf);
      preorder(r.right, currNumber, rootToLeaf);
    }
  }

  public int SumAnotherMethod(Node root) {
    int rootToLeaf = 0;
    preorder(root, 0, rootToLeaf);
    return rootToLeaf;
  }

  class Pair {
    Node node;
    int curr;

    Pair(Node node, int curr) {
      this.node = node;
      this.curr = curr;
    }
  }
}
