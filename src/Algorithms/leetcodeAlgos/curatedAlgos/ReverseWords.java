package Algorithms.leetcodeAlgos.curatedAlgos;

import java.util.Stack;

class ReverseWords {
  public static void main(String[] args) {
    String s = "the sky is blue";
    reverseWords(s);
  }

  public static String reverseWords(String s) {
    int n = s.length();
    StringBuilder builder = new StringBuilder();
    Stack<String> stack = new Stack<>();
    for (int i = 0; i < n; ) {
      int start = i;
      while (i < n && s.charAt(i) != ' ') i++;
      int end = i;
      while (i < n && s.charAt(i) == ' ') i++;
      stack.push(s.substring(start, end));
    }

    while (!stack.isEmpty()) {
      builder.append(stack.pop());
      builder.append(" ");
    }
    String ans = builder.toString().trim();
    return ans;
  }
}
