package algorithms.stack;

import java.util.Stack;

public class PreviousSmaller {
  public static void main(String[] args) {
    int[] arr = new int[] {20, 30, 10, 5, 15};
    previousSmaller(arr);
  }

  private static void previousSmaller(int[] arr) {
    Stack<Integer> s = new Stack<>();
    s.push(arr[0]);
    for (int i = 0; i < arr.length; i++) {
      while (!s.empty() && s.peek() >= arr[i]) s.pop();
      int ps = s.empty() ? -1 : s.peek();
      System.out.print(ps + " ");
      s.push(arr[i]);
    }
  }
}
