package Algorithms.strings;

public class PatternSearching {
  public static void main(String[] args) {
    String txt = "GEEKSFORGEEKS";
    String pat = "EKS";
    searchPatternNaive(txt, pat);
    searchPatternNaiveImproved(txt, pat);
    searchPatternRabinKarp(txt, pat);
  }

  private static void searchPatternRabinKarp(String txt, String pat) {}

  private static void searchPatternNaive(String txt, String pat) {
    int m = pat.length();
    int n = txt.length();
    for (int i = 0; i <= n - m; i++) {
      int j;
      for (j = 0; j < m; j++) if (pat.charAt(j) != txt.charAt(i + j)) break;
      if (j == m) System.out.print(i + " ");
    }
  }

  private static void searchPatternNaiveImproved(String txt, String pat) {
    int m = pat.length();
    int n = txt.length();
    for (int i = 0; i <= n - m; ) {
      int j;
      for (j = 0; j < m; j++) if (pat.charAt(j) != txt.charAt(i + j)) break;
      if (j == m) System.out.print(i + " ");
      if (j == 0) i++;
      else i = i + j;
    }
  }
}
