package Algorithms.leetcodeAlgos.curatedAlgos;

import java.util.ArrayList;
import java.util.List;

class RemoveComments {
  public static void main(String[] args) {
    String source[] =
        new String[] {
          "/*Test program */",
          "int main()",
          "{ ",
          "  // variable declaration ",
          "int a, b, c;",
          "/* This is a test",
          "   multiline  ",
          "   comment for ",
          "   testing */",
          "a = b + c;",
          "}"
        };

    removeComments(source);
  }

  public static List<String> removeComments(String[] source) {
    for (int i = 0; i < source.length; i++) {
      source[i] = source[i].trim();
    }
    List<String> ans = new ArrayList<>();
    for (int i = 0; i < source.length; i++) {
      String s = source[i];
      if (s.charAt(0) == '/' && s.charAt(1) == '/') continue;
      if (s.charAt(0) == '/'
          && s.charAt(1) == '*'
          && s.charAt(s.length() - 1) == '/'
          && s.charAt(s.length() - 2) == '*') continue;
      if (s.charAt(0) == '/' && s.charAt(1) == '*' && s.charAt(s.length() - 1) != '/') {
        String t = s;
        while (t.charAt(t.length() - 1) != '/') {
          i++;
          t = source[i];
          continue;
        }
        i++;
        if (i < source.length) ans.add(source[i]);
      } else ans.add(source[i]);
    }

    return ans;
  }
}
