package Algorithms.stack;

import java.util.Stack;

public class PreviousGreaterElement {
  public static void main(String[] args) {
    int[] arr = new int[] {20, 30, 10, 5, 15};
    previousGreater(arr);
  }

  private static void previousGreater(int[] arr) {
    Stack<Integer> s = new Stack<>();
    s.push(arr[0]);
    for (int i = 0; i < arr.length; i++) {
      while (!s.empty() && s.peek() <= arr[i]) s.pop();
      int pg = s.empty() ? -1 : s.peek();
      System.out.print(pg + " ");
      s.push(arr[i]);
    }
  }
}
