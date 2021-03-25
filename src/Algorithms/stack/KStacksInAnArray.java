package Algorithms.stack;

public class KStacksInAnArray {
  int k, freetop, cap;
  int[] arr;
  int[] top;
  int[] next;

  KStacksInAnArray(int k, int n) {
    this.k = k;
    this.cap = n;
    this.top = new int[k];
    this.next = new int[n];
    this.arr = new int[n];
    for (int i = 0; i < k; i++) top[i] = -1;
    freetop = 0;
    for (int i = 0; i < cap - 1; i++) next[i] = i + 1;
    next[cap - 1] = -1;
  }

  void push(int x, int sn) {
    int i = freetop;
    freetop = next[i];
    next[i] = top[sn];
    top[sn] = i;
    arr[i] = x;
  }

  int pop(int sn) {
    int i = top[sn];
    top[sn] = next[i];
    next[i] = freetop;
    freetop = i;
    return arr[i];
  }
}
