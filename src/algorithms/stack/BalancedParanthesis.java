package algorithms.stack;

import java.util.Stack;

public class BalancedParanthesis {
  public static void main(String[] args) {
    String s = "[(){()}]";
    System.out.println(isBalanced(s));
  }

  private static boolean isBalanced(String str) {
    Stack<Character> s = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[')
        s.push(str.charAt(i));
      else {
        if (s.empty()) // we must not have closing bracket before opening bracket
        return false;
        else if (!matching(s.peek(), str.charAt(i))) return false;
        else s.pop();
      }
    }
    return (s.empty());
  }

  private static boolean matching(Character a, char b) {
    return ((a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}'));
  }
}
