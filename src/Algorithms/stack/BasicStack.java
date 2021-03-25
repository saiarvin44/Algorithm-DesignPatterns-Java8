package Algorithms.stack;

public class BasicStack {
  int[] arr;
  int cap, top;

  BasicStack(int c) {
    top = -1;
    cap = c;
    arr = new int[cap];
  }

  void push(int x) {
    if (top == cap - 1) System.out.println("Overflow");
    top++;
    arr[top] = x;
  }

  int pop() {
    if (top == -1) System.out.println("Underflow");
    int res = arr[top];
    top--;
    return res;
  }

  int peek() {
    if (top == -1) System.out.println("underflow");
    return arr[top];
  }

  int size() {
    return top + 1;
  }

  boolean isEmpty() {
    return top == -1;
  }
}

class Test {
  public static void main(String[] args) {
    BasicStack s = new BasicStack(5);
    s.push(10);
    s.push(20);
    System.out.println(s.pop());
    s.push(30);
  }
}
