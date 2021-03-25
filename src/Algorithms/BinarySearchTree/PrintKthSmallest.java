package Algorithms.BinarySearchTree;

public class PrintKthSmallest {
  public void printKth(Node root, int k) {
    int count = 0;
    if (root != null) {
      printKth(root.left, k);
      count++;
      if (count == k) System.out.print(root.key);
      printKth(root.right, k);
    }
  }
}
