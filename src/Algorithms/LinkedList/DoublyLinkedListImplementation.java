package Algorithms.LinkedList;

public class DoublyLinkedListImplementation {}

class DoubleNode {
  int data;
  DoubleNode prev, next;

  DoubleNode(int d) {
    data = d;
    prev = null;
    next = null;
  }
}

class DoubleLinkedListTest {
  public static void main(String[] args) {
    DoubleNode head = new DoubleNode(10);
    DoubleNode temp1 = new DoubleNode(20);
    DoubleNode temp2 = new DoubleNode(30);
    head.next = temp1;
    temp1.prev = head;
    temp1.next = temp2;
    temp2.prev = temp1;
    head = insertBegin(head, 5);
    head = insertEnd(head, 40);
    head = reverse(head);
    head = deleteHead(head);
    head = deleteLast(head);
    printList(head);
  }

  private static DoubleNode deleteLast(DoubleNode head) {
    if (head == null) return null;
    if (head.next == null) return null;
    DoubleNode curr = head;
    while (curr.next != null) curr = curr.next;
    curr.prev.next = null;
    return head;
  }

  private static DoubleNode deleteHead(DoubleNode head) {
    if (head == null) return null;
    if (head.next == null) return null;
    else {
      head = head.next;
      head.prev = null;
      return head;
    }
  }

  private static DoubleNode reverse(DoubleNode head) {
    if (head == null || head.next == null) return head;
    DoubleNode prev = null, curr = head;
    while (curr != null) {
      prev = curr.prev;
      curr.prev = curr.next;
      curr.next = prev;
      curr = curr.prev;
    }
    return prev.prev;
  }

  private static DoubleNode insertEnd(DoubleNode head, int d) {
    DoubleNode node = new DoubleNode(d);
    if (head == null) return node;
    DoubleNode curr = head;
    while (curr.next != null) curr = curr.next;
    curr.next = node;
    node.prev = curr;
    return head;
  }

  private static DoubleNode insertBegin(DoubleNode head, int d) {
    DoubleNode node = new DoubleNode(d);
    node.next = head;
    if (head != null) head.prev = node;
    return node;
  }

  private static void printList(DoubleNode head) {
    DoubleNode curr = head;
    while (curr != null) {
      System.out.print(curr.data + "-->");
      curr = curr.next;
    }
    System.out.println();
  }
}
