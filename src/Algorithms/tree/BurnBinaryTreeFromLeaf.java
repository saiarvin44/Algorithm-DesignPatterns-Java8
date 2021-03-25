package Algorithms.tree;

public class BurnBinaryTreeFromLeaf {

  /**
   * return the height of binary tree with given root node.
   * return distance from current node to leaf node if leaf node is descendant
   * pass dist as -1
   */
  int res = 0;

  int burnTree(Representation root, int leaf, Distance dist) {
    if (root == null) return 0;
    if (root.key == leaf) {
      dist.val = 0;
      return 1;
    }
    Distance ldist = new Distance(-1), rdist = new Distance(-1);
    int lh = burnTree(root.left, leaf, ldist);
    int rh = burnTree(root.right, leaf, rdist);

    if (ldist.val != -1) {
      dist.val = ldist.val + 1;
      res = Math.max(res, rh + dist.val);
    } else if (rdist.val != -1) {
      dist.val = rdist.val + 1;
      res = Math.max(res, dist.val + lh);
    }
    return Math.max(lh, rh) + 1;
  }
}

class Distance {
  int val;

  Distance(int d) {
    val = d;
  }
}
