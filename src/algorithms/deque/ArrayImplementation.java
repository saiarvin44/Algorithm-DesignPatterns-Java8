package algorithms.deque;

public class ArrayImplementation {
  int size, cap;
  int[] arr;
  int front;

  ArrayImplementation(int c) {
    cap = c;
    size = 0;
    arr = new int[cap];
    front = 0;
  }

  private void deleteFront() {
    if (isEmpty()) return;
    front = (front + 1) % cap;
    size--;
  }

  private void insertRear(int x) {
    if (isFull()) return;
    int new_rear = (front + size) % cap;
    arr[new_rear] = x;
    size++;
  }

  private void insertFront(int x) {
    if (isFull()) return;
    front = (front + cap - 1) % cap;
    arr[front] = x;
    size++;
  }

  private void deleteRear() {
    if (isEmpty()) return;
    size--;
  }

  private int getFront() {
    if (isEmpty()) return -1;
    else return front;
  }

  private int getRear() {
    if (isEmpty()) return -1;
    return (front + size - 1) % cap;
  }

  private boolean isEmpty() {
    return size == 0;
  }

  private boolean isFull() {
    return size == cap;
  }
}
