package Algorithms.leetcodeAlgos.curatedAlgos;

class SmallestDivisorOf2Strings {

  public static int findSmallestDivisor(String s, String t) {

    int sL = s.length();
    int tL = t.length();
    if (sL % tL != 0) return -1;
    int ans = 0;
    for (int i = 1; i <= Math.min(sL, tL); i++) {
      if (sL % i == 0 && tL % i == 0) {
        if (s.substring(0, i).equals(t.substring(0, i))) {
          if (check(s, i) && check(t, i)) ans++;
        }
      }
    }
    return ans;
  }

  public static boolean check(String s, int n) {
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != s.charAt(i % n)) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.print(findSmallestDivisor("xaxa", "xaxaxaxa"));
  }
}
