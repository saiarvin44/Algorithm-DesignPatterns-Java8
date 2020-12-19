package algorithms.strings;

import java.util.Arrays;

public class FindIfAnagramOfStringIsPresentInAnother {
  public static void main(String[] args) {
    String txt = "geeksforgeeks";
    String pat = "frog";
    boolean ans = naiveMethod(txt, pat);
    boolean ans2 = optimized(txt, pat);
    System.out.println(ans2);
  }

  private static boolean optimized(String txt, String pat) {
    int[] ct = new int[256];
    int[] cp = new int[256];
    Arrays.fill(ct, 0);
    Arrays.fill(cp, 0);
    for (int i = 0; i < pat.length(); i++) {
      ct[txt.charAt(i)]++;
      cp[txt.charAt(i)]++;
    }
    for (int i = pat.length(); i < txt.length(); i++) {
      if (areSame(ct, cp)) return true;
      ct[txt.charAt(i)]++;
      ct[txt.charAt(i - pat.length())]--;
    }
    return false;
  }

  private static boolean areSame(int[] ct, int[] cp) {
    for (int i = 0; i < 256; i++) if (ct[i] != cp[i]) return false;
    return true;
  }

  private static boolean naiveMethod(String txt, String pat) {
    int n = txt.length();
    int m = pat.length();
    for (int i = 0; i <= n - m; i++) if (areAnagram(pat, txt, i)) return true;
    return false;
  }

  private static boolean areAnagram(String s1, String s2, int size) {
    int[] count = new int[256];
    for (int i = 0; i < s1.length(); i++) {
      count[s1.charAt(i)]++;
      count[s2.charAt(i + size)]--;
    }
    for (int i = 0; i < 256; i++) if (count[i] != 0) return false;
    return true;
  }
}
