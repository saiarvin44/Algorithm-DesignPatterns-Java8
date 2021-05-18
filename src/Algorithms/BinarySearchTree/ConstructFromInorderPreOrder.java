package Algorithms.BinarySearchTree;

public class ConstructFromInorderPreOrder {
  private static int preIndex = 0;

  public static void main(String[] args) {

    int[] in = new int[] {20, 10, 40, 30, 50};
    int[] pre = new int[] {10, 20, 30, 40, 50};
    Node root = cTree(in, pre, 0, in.length - 1);
  }

  private static Node cTree(int[] in, int[] pre, int is, int ie) {
    if (is > ie) return null;
    Node root = new Node(pre[preIndex++]);
    int inIndex = 0;
    for (int i = is; i <= ie; i++)
      if (in[i] == root.key) {
        inIndex = i;
        break;
      }
    root.left = cTree(in, pre, is, inIndex - 1);
    root.right = cTree(in, pre, inIndex + 1, ie);
    return root;
  }
}
