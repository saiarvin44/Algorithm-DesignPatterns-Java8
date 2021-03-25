package Algorithms.BinarySearchTree;

import java.util.HashSet;

public class PairWithGivenSumInBST {
  boolean isPairSum(Node root, int sum, HashSet<Integer> s) {
    if (root == null) return false;
    if (isPairSum(root.left, sum, s) == true) return true;
    if (s.contains(sum - root.key)) return true;
    else s.add(root.key);
    return isPairSum(root.right, sum, s);
  }
}
