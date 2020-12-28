package algorithms.queue;

class Node {
  int data;
  Node next;

  Node(int x) {
    data = x;
    next = null;
  }
}

public class LinkedListImplementation {
  Node front, rear;

  LinkedListImplementation() {
    front = rear = null;
  }

  void enque(int x) {
    Node temp = new Node(x);
    if (front == null) {
      front = rear = temp;
      return;
    }
    rear.next = temp;
    rear = temp;
  }

  void deque() {
    if (front == null) return;
    front = front.next;
    if (front == null) return;
  }
}
