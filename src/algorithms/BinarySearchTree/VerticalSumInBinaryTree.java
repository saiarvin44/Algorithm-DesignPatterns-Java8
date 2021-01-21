package algorithms.BinarySearchTree;

import java.util.Map;
import java.util.TreeMap;

public class VerticalSumInBinaryTree {
  public static void verticalSum(Node root) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    verticalSumRecursive(root, 0, map);
    for (Map.Entry sum : map.entrySet()) System.out.print(sum.getValue() + " ");
  }

  private static void verticalSumRecursive(
      Node root, int horizontalDistance, TreeMap<Integer, Integer> treeMap) {
    if (root == null) return;
    verticalSumRecursive(root.left, horizontalDistance - 1, treeMap);
    int pSum = (treeMap.get(horizontalDistance) == null) ? 0 : treeMap.get(horizontalDistance);
    treeMap.put(horizontalDistance, pSum + root.key);
    verticalSumRecursive(root.right, horizontalDistance + 1, treeMap);
  }
}
