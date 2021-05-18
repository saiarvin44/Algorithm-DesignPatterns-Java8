package Algorithms.Trie;

public class DistinctRowsIn2DArray {
  static final int M = 4, N = 3;
  static int mat[][] = {
    {1, 0, 0},
    {1, 1, 1},
    {1, 0, 0},
    {0, 1, 0}
  };

  static boolean insert(Trie root, int row) {
    Trie curr = root;
    boolean flag = false;
    for (int i = 0; i < N; i++) {
      int index = mat[row][i];
      if (curr.child[index] == null) {
        curr.child[index] = new Trie();
        flag = true;
      }
      curr = curr.child[index];
    }
    return flag;
  }

  static int countDis() {
    Trie root = new Trie();
    int res = 0;
    for (int row = 0; row < N; row++) if (insert(root, row)) res++;
    return res;
  }

  public static void main(String[] args) {
    System.out.print(countDis());
  }

  static class Trie {
    Trie[] child;

    Trie() {
      child = new Trie[2];
      child[0] = null;
      child[1] = null;
    }
  }
}
