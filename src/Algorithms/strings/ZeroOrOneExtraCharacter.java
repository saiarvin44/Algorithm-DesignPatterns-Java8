package Algorithms.strings;

public class ZeroOrOneExtraCharacter {
  public static void main(String[] args) {
    String a = "aaabbcddc";
    int ans = findIfValid(a);
    if ((ans >= 97 && ans <= 122) || ans == 0) System.out.print("True");
    else System.out.print("False");
  }

  private static int findIfValid(String str) {
    int ans = 0;
    for (int i = 0; i < str.length(); i++) ans ^= str.charAt(i);
    return ans;
  }
}
