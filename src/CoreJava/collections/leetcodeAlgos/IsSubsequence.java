package CoreJava.collections.leetcodeAlgos;

public class IsSubsequence {
  public static void main(String[] args) {
    System.out.println(isSubsequence("acb", "ahbgdc"));
  }

  public static boolean isSubsequence(String s, String t) {
    if (s.equals("")) return true;
    int sL = s.length();
    int tL = t.length();
    if (tL < sL) return false;
    if (tL == 1 && sL == 1 && s.charAt(0) == t.charAt(0)) return true;
    if (tL == 1 && sL == 1 && s.charAt(0) != t.charAt(0)) return false;
    int cS = 0;
    for (int i = 0; i < tL; i++) {
      if (t.charAt(i) == s.charAt(cS)) cS++;
      if (cS == sL) break;
    }
    if (cS == sL) return true;
    return false;
  }
}
