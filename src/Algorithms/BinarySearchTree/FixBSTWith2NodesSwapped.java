package Algorithms.BinarySearchTree;

public class FixBSTWith2NodesSwapped {

  public static void main(String[] args) {
    int[] arr = new int[] {4, 60, 10, 20, 8, 80, 100};
    System.out.print(fixArray(arr)[0] + ":" + fixArray(arr)[1]);
  }

  static Node prev = null, first = null, second = null;

  static void fixBST(Node root) {
    if (root == null) return;
    fixBST(root.left);
    if (prev != null && root.key < prev.key) {
      if (first == null) first = prev;
      second = root;
    }
    prev = root;
    fixBST(root.right);
  }

  static int[] fixArray(int[] arr) {
    Integer prev = Integer.MIN_VALUE, first = null, second = null;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < prev) {
        if (first == null) first = prev;
        second = arr[i];
      }
      prev = arr[i];
    }
    return new int[] {first, second};
  }
}
