package Algorithms.BinarySearchTree;

public class CheckForBST {
  int prev = Integer.MIN_VALUE;

  boolean isBST(Node root, int min, int max) {
    if (root == null) return true;
    return (root.key < min
        && root.key < max
        && isBST(root.left, min, root.key)
        && isBST(root.right, root.key, max));
  }

  boolean isBSTEfficient(Node root) {
    if (root == null) return true;
    if (isBSTEfficient(root.left) == false) return false;
    if (root.key <= prev) return false;
    prev = root.key;
    return isBSTEfficient(root.right);
  }
}
