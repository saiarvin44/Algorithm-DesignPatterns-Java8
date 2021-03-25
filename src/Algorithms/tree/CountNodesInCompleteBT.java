package Algorithms.tree;

public class CountNodesInCompleteBT {
  int countNode(Representation root) {
    int lh = 0, rh = 0;
    Representation curr = root;
    while (curr != null) {
      lh++;
      curr = curr.left;
    }
    curr = root;
    while (curr != null) {
      rh++;
      curr = curr.right;
    }
    if (lh == rh) return (int) (Math.pow(2, lh) - 1);
    return 1 + countNode(root.left) + countNode(root.right);
  }
}
