package Algorithms.stack;

public class LinkedListStack {
  Node head;
  int s;

  LinkedListStack() {
    head = null;
    s = 0;
  }

  int size() {
    return s;
  }

  boolean isEmpty() {
    return head == null;
  }

  void push(int x) {
    Node temp = new Node(x);
    temp.next = head;
    head = temp;
    s++;
  }

  int pop() {
    if (head == null) return Integer.MAX_VALUE;
    int res = head.data;
    head = head.next;
    s--;
    return res;
  }

  int peek() {
    if (head == null) return Integer.MAX_VALUE;
    return head.data;
  }
}

class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}
