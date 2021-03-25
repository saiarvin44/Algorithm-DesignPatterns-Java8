package Algorithms.stack;

import java.util.Stack;

public class LargestRectangleAreaInHistogram {
  public static void main(String[] args) {
    int[] arr = new int[] {6, 2, 5, 4, 1, 5, 6};
    System.out.println(naive(arr));
    System.out.println(efficient(arr));
    System.out.println(lessEfficient(arr));
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

  private static int lessEfficient(int[] arr) {
    int[] ps = new int[arr.length];
    int[] ns = new int[arr.length];
    ns[arr.length - 1] = arr.length;

    int curr, res = 0;

    Stack<Integer> psStack = new Stack<>();
    Stack<Integer> nsStack = new Stack<>();

    nsStack.push(arr[arr.length - 1]);
    psStack.push(arr[0]);

    for (int i = 0; i < arr.length; i++) {
      while (!psStack.isEmpty() && psStack.peek() >= arr[i]) psStack.pop();
      ps[i] = psStack.empty() ? -1 : psStack.peek();
      psStack.push(arr[i]);
    }

    for (int i = arr.length - 2; i >= 0; i--) {
      while (!nsStack.isEmpty() && nsStack.peek() <= arr[i]) nsStack.pop();
      ns[i] = nsStack.empty() ? arr.length : nsStack.peek();
      nsStack.push(arr[i]);
    }

    for (int i = 0; i < arr.length; i++) {
      curr = arr[i];
      curr += ((i - ps[i] - 1) * arr[i]);
      curr += ((ns[i] - i - 1) * arr[i]);
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
