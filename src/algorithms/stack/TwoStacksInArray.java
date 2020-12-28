package algorithms.stack;

public class TwoStacksInArray {
  public static void main(String[] args) {}
}

class TwoStacks {
  int[] arr;
  int cap, top1, top2;

  TwoStacks(int n) {
    cap = n;
    top1 = -1;
    top2 = n;
    arr = new int[n];
  }

  void push1(int x) {
    if (top1 < top2 - 1) {
      top1++;
      arr[top1] = x;
    }
  }

  void push2(int x) {
    if (top1 < top2 - 1) {
      top2--;
      arr[top2] = x;
    }
  }

  int pop1() {
    if (top1 >= 0) {
      int x = arr[top1];
      top1--;
      return x;
    }
    return -1;
  }

  int pop2() {
    if (top2 < cap) {
      int x = arr[top2];
      top2++;
      return x;
    }
    return -1;
  }
}
