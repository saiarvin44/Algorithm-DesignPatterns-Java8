package algorithms.LinkedList;

public class CircularLinkedList {
  public static void main(String[] args) {
    Node head = new Node(10);
    head.next = new Node(20);
    head.next.next = new Node(30);
    head.next.next.next = head;
    head = insertBegining(head, 5);
    head = insertEnd(head, 40);
    head = deleteHead(head);
    head = deleteKthElt(head, 3);
    printlist(head);
  }

  private static Node deleteKthElt(Node head, int k) {
    if (head == null) return head;
    if (k == 1) return deleteHead(head);
    Node curr = head;
    for (int i = 0; i < k - 2; i++) curr = curr.next;
    curr.next = curr.next.next;
    return head;
  }

  private static Node deleteHead(Node head) {
    if (head == null) return null;
    if (head.next == head) return null;
    Node curr = head;
    while (curr.next != head) curr = curr.next;
    curr.next = head.next;
    return curr.next;
  }

  private static Node insertEnd(Node head, int e) {
    Node temp = new Node(e);
    if (head == null) {
      temp.next = temp;
      return temp;
    } else {
      Node curr = head;
      while (curr.next != head) curr = curr.next;
      curr.next = temp;
      temp.next = head;
      return head;
    }
  }

  private static Node insertBegining(Node head, int e) {
    Node temp = new Node(e);
    if (head == null) temp.next = temp;
    else {
      Node curr = head;
      while (curr.next != head) curr = curr.next;
      curr.next = temp;
      temp.next = head;
    }
    return temp;
  }

  private static void printlist(Node head) {
    if (head == null) return;
    System.out.print(head.data + " ");
    for (Node t = head.next; t != head; t = t.next) System.out.print(t.data + " ");
    System.out.println();
  }
}
