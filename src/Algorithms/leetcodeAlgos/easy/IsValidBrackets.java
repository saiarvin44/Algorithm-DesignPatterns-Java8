package Algorithms.leetcodeAlgos.easy;

import java.util.LinkedList;
import java.util.Queue;

public class IsValidBrackets {
  public static void main(String[] args) {
    System.out.println("Valid brackets : " + isValid("([)]"));
  }

  public static boolean isValid(String s) {
    boolean result = true;
    Queue<Character> queue = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') queue.add(s.charAt(i));
    }
    if (queue.isEmpty()) return false;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') continue;
      Character poppedBracket = null;
      if (!queue.isEmpty()) poppedBracket = queue.remove();
      if (!((poppedBracket == '(' && s.charAt(i) == ')')
          || (poppedBracket == '{' && s.charAt(i) == '}')
          || (poppedBracket == '[' && s.charAt(i) == ']'))) {
        result = false;
        break;
      }
    }
    if (!queue.isEmpty()) return false;
    return result;
  }
}
