package Algorithms.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextGreaterElement {
  public static void main(String[] args) {
    int[] arr = new int[] {5, 15, 10, 8, 6, 12, 9, 18};
    nextGreater(arr);
  }

  private static void nextGreater(int[] arr) {
    Stack<Integer> s = new Stack<>();
    ArrayList<Integer> ans = new ArrayList<>();
    s.push(arr[arr.length - 1]);
    for (int i = arr.length - 2; i >= 0; i--) {
      while (!s.empty() && s.peek() <= arr[i]) s.pop();
      int ng = s.empty() ? -1 : s.peek();
      ans.add(ng);
      // System.out.print(ng + " ");
      s.push(arr[i]);
    }
    Collections.reverse(ans);
    for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
  }
}
