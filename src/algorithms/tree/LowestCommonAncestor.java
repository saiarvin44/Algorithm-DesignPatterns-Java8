package algorithms.tree;

import java.util.ArrayList;

public class LowestCommonAncestor {
  boolean findPath(Representation root, ArrayList<Representation> p, int n) {
    if (root == null) return false;
    p.add(root);
    if (root.key == n) return true;
    if (findPath(root.left, p, n) || findPath(root.right, p, n)) return true;
    p.remove(p.size() - 1);
    return false;
  }

  Representation LCA(Representation root, int n1, int n2) {
    ArrayList<Representation> path1 = new ArrayList<>();
    ArrayList<Representation> path2 = new ArrayList<>();
    if (findPath(root, path1, n1) == false || findPath(root, path2, n2) == false) return null;
    for (int i = 0; i < path1.size() - 1 && i < path2.size() - 1; i++)
      if (path1.get(i + 1) != path2.get(i + 1)) return path1.get(i);
    return null;
  }

  Representation LCAEfficient(Representation root, int n1, int n2) {
    if (root == null) return null;
    if (root.key == n1 || root.key == n2) return root;
    Representation LCA1 = LCAEfficient(root.left, n1, n2);
    Representation LCA2 = LCAEfficient(root.right, n1, n2);
    if (LCA1 != null && LCA2 != null) return root;
    if (LCA1 != null) return LCA1;
    return LCA2;
  }
}
