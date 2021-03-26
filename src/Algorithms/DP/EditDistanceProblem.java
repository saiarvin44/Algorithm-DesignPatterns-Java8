package Algorithms.DP;

public class EditDistanceProblem {

  public static void main(String[] args) {
    String s1 = "saturday", s2 = "sunday";
    System.out.print(eDTabulation(s1, s2, s1.length(), s2.length()));
  }

  static int eD(String s1, String s2, int m, int n) {
    if (m == 0) return n;
    if (n == 0) return m;
    if (s1.charAt(m - 1) == s2.charAt(n - 1)) return eD(s1, s2, m - 1, n - 1);
    else
      return 1
          + Math.min(
              Math.min(eD(s1, s2, m, n - 1), eD(s1, s2, m - 1, n)),
              eD(s1, s2, m - 1, n - 1)); // insert, delete, replace
  }

  static int eDTabulation(String s1, String s2, int m, int n) {
    int[][] db = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) db[i][0] = i;
    for (int i = 0; i <= n; i++) db[0][i] = i;
    for (int i = 1; i <= m; i++)
      for (int j = 1; j <= n; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) db[i][j] = db[i - 1][j - 1];
        else db[i][j] = 1 + Math.min(Math.min(db[i][j - 1], db[i - 1][j]), db[i - 1][j - 1]);
      }
    return db[m][n];
  }
}
