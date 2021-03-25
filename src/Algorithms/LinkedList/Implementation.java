package Algorithms.LinkedList;

public class Implementation {}

class Node {
  int data;
  Node next;

  Node(int x) {
    data = x;
    next = null;
  }
}

class Test {
  public static void main(String[] args) {
    Node head = null;
    head = insertBegin(head, 30);
    head = insertBegin(head, 20);
    head = insertBegin(head, 10);
    head = insertEnd(head, 40);
    printList(head);
    head = deleteBegin(head);
    printList(head);
    head = deleteEnd(head);
    printList(head);
    head = insertAtGivenPos(head, 2, 50);
    printListRecursive(head);
    System.out.println();
    int pos = SearchEltInLinkedList(head, 50);
    int pos2 = SearchEltInLinkedRecursiveList(head, 50);
    System.out.println(pos + ", " + pos2);
  }

  private static int SearchEltInLinkedRecursiveList(Node head, int e) {
    if (head == null) return -1;
    if (head.data == e) return 1;
    else {
      int res = SearchEltInLinkedRecursiveList(head.next, e);
      if (res == -1) return -1;
      else return res + 1;
    }
  }

  private static int SearchEltInLinkedList(Node head, int elt) {
    int pos = 1;
    Node curr = head;
    while (curr != null) {
      if (curr.data == elt) return pos;
      else {
        pos++;
        curr = curr.next;
      }
    }
    return -1;
  }

  private static Node insertAtGivenPos(Node head, int pos, int val) {
    Node temp = new Node(val);
    if (pos == 1) {
      temp.next = head;
      return temp;
    }
    Node curr = head;
    for (int i = 1; i <= pos - 2 && curr != null; i++) curr = curr.next;
    if (curr == null) return head;
    temp.next = curr.next;
    curr.next = temp;
    return head;
  }

  private static Node deleteEnd(Node head) {
    if (head == null) return null;
    if (head.next == null) return null;
    Node curr = head;
    while (curr.next.next != null) curr = curr.next;
    curr.next = null;
    return head;
  }

  private static Node deleteBegin(Node head) {
    if (head == null) return null;
    else return head.next;
  }

  protected static Node insertEnd(Node head, int x) {
    Node temp = new Node(x);
    if (head == null) return temp;
    Node curr = head;
    while (curr.next != null) curr = curr.next;
    curr.next = temp;
    return head;
  }

  protected static Node insertBegin(Node head, int i) {
    Node temp = new Node(i);
    temp.next = head;
    return temp;
  }

  private static void printListRecursive(Node head) {
    if (head == null) return;
    System.out.print(head.data + "-->");
    printListRecursive(head.next);
  }

  protected static void printList(Node head) {
    Node curr = head;
    while (curr != null) {
      System.out.print(curr.data + "-->");
      curr = curr.next;
    }
    System.out.println();
  }
}
