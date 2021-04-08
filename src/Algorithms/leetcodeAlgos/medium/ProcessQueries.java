package Algorithms.leetcodeAlgos.medium;

class ProcessQueries {
  public static void main(String[] args) {
    int[] queries = new int[] {3, 1, 2, 1};
    int m = 5;
    processQueries(queries, m);
  }

  public static int[] processQueries(int[] queries, int m) {
    int[] P = new int[m];
    int[] ans = new int[queries.length];
    for (int i = 1; i <= m; i++) P[i - 1] = i;
    for (int i = 0; i < queries.length; i++)
      for (int j = 0; j < m; j++)
        if (P[j] == queries[i]) {
          ans[i] = j;
          change(P, j);
        }
    return ans;
  }

  public static void change(int[] P, int i) {
    int[] temp = new int[P.length];
    int c = 0;
    int tempVar = P[i];
    temp[0] = tempVar;
    for (int j = 0; j < P.length; j++) {
      if (j != i) temp[++c] = P[j];
    }
    for (int j = 0; j < P.length; j++) P[j] = temp[j];
  }
}
