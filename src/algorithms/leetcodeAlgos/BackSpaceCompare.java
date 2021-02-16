package algorithms.leetcodeAlgos;

public class BackSpaceCompare {
  public static void main(String[] args) {
    System.out.print(backspaceCompare("ab##", "c#d#"));
  }

  public static boolean backspaceCompare(String S, String T) {
    StringBuilder s = new StringBuilder();
    StringBuilder t = new StringBuilder();
    for (int i = 0; i < S.length(); i++) {
      if (!(S.charAt(i) == '#')) s.append(S.charAt(i));
      else {
        if ((s.length() - 1) >= 0) s.deleteCharAt(s.length() - 1);
      }
    }

    for (int i = 0; i < T.length(); i++) {
      if (!(T.charAt(i) == '#')) t.append(T.charAt(i));
      else {
        if ((t.length() - 1) >= 0) t.deleteCharAt(t.length() - 1);
      }
    }

    String sS = s.toString(), tS = t.toString();
    if (sS.equals(tS)) return true;
    return false;
  }
}
