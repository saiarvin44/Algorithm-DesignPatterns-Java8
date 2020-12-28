package algorithms.queue;

public class CircularArrayImplementation {
  int[] arr;
  int front, cap, size;

  CircularArrayImplementation(int c) {
    arr = new int[c];
    cap = c;
    front = 0;
    size = 0;
  }

  private void enque(int x) {
    if (isFull()) return;
    int rear = getRear();
    rear = (rear + 1) % cap;
    arr[rear] = x;
    size++;
  }

  private void deque() {
    if (isEmpty()) return;
    front = (front + 1) % cap;
    size--;
  }

  private int getRear() {
    if (isEmpty()) return -1;
    else return (front + size - 1) % cap;
  }

  private boolean isEmpty() {
    return size == 0;
  }

  private boolean isFull() {
    return cap == size;
  }
}
