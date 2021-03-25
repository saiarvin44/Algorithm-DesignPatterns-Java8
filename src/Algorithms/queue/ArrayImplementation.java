package Algorithms.queue;

public class ArrayImplementation {
  int size, cap;
  int[] arr;

  ArrayImplementation(int c) {
    cap = c;
    size = 0;
    arr = new int[cap];
  }

  private void enque(int x) {
    if (isFull()) return;
    arr[size] = x;
    size++;
  }

  private void deque() {
    if (isEmpty()) return;
    for (int i = 0; i < size - 1; i++) arr[i] = arr[i + 1];
  }

  private boolean isEmpty() {
    return size == 0;
  }

  private boolean isFull() {
    return size == cap;
  }

  private int getFront() {
    if (isEmpty()) return -1;
    else return 0;
  }

  private int getRear() {
    if (isEmpty()) return -1;
    else return size - 1;
  }
}
