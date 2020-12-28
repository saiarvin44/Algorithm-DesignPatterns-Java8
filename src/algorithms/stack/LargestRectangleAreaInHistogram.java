package algorithms.stack;

import java.util.Stack;

public class LargestRectangleAreaInHistogram {
  public static void main(String[] args) {
    int[] arr = new int[] {6, 2, 5, 4, 1, 5, 6};
    System.out.println(naive(arr));
    System.out.println(efficient(arr));
  }

  private static int efficient(int[] arr) {
    Stack<Integer> s = new Stack();
    int res = 0, tp, curr;
    for (int i = 0; i < arr.length; i++) {

      while (!s.empty() && arr[s.peek()] >= arr[i]) {
        tp = s.pop();
        curr = arr[tp] * (s.empty() ? i : (i - s.peek() - 1));
        res = Math.max(res, curr);
      }
      s.push(i);
    }
    while (!s.empty()) {
      tp = s.pop();
      curr = arr[tp] * (s.empty() ? arr.length : (arr.length - s.peek() - 1));
      res = Math.max(res, curr);
    }
    return res;
  }

  private static int naive(int[] arr) {
    int res = 0;
    for (int i = 0; i < arr.length; i++) {
      int curr = arr[i];
      for (int j = i - 1; j >= 0; j--) {
        if (arr[j] >= arr[i]) curr += arr[i];
        else break;
      }
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] >= arr[i]) curr += arr[i];
        else break;
      }
      res = Math.max(res, curr);
    }
    return res;
  }
}
