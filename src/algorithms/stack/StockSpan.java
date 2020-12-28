package algorithms.stack;

import java.util.ArrayDeque;

public class StockSpan {
  public static void main(String[] args) {
    int[] arr = new int[] {18, 12, 13, 14, 11, 16};
    printSpanNaive(arr);
    System.out.println();
    printSpanEfficient(arr);
  }

  private static void printSpanEfficient(int[] arr) {
    ArrayDeque<Integer> s = new ArrayDeque<>();
    s.push(0);
    System.out.print(1 + " ");
    int span;
    for (int i = 1; i < arr.length; i++) {
      while (!s.isEmpty() && arr[s.peek()] <= arr[i]) s.pop();
      span = s.isEmpty() ? i + 1 : i - s.peek();
      System.out.print(span + " ");
      s.push(i);
    }
  }

  private static void printSpanNaive(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int span = 1;
      for (int j = i - 1; j >= 0 && arr[j] <= arr[i]; j--) span++;
      System.out.print(span + " ");
    }
  }
}
