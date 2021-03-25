package Algorithms.leetcodeAlgos;

import java.util.Stack;

public class makeGoodStrings {
  public static void main(String[] args) {
    System.out.println(makeGood("abBAcC"));
  }

  public static String makeGood(String s) {
    Stack<Character> stack = new Stack<>();
    if (s.equals("")) return "";
    stack.push(s.charAt(0));
    for (int i = 1; i < s.length(); i++) {
      if (stack.size() > 0
          && (((int) stack.peek() == (int) s.charAt(i) + 32)
              || ((int) stack.peek() == (int) s.charAt(i) - 32))) stack.pop();
      else stack.push(s.charAt(i));
    }
    StringBuilder builder = new StringBuilder();
    while (!stack.isEmpty()) {
      builder.append(stack.pop());
    }
    return builder.reverse().toString();
  }
}
