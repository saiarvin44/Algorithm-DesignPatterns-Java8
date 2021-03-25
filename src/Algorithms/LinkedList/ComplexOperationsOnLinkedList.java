package Algorithms.LinkedList;

import java.util.HashSet;

import static Algorithms.LinkedList.Test.*;

public class ComplexOperationsOnLinkedList {
  public static void main(String[] args) {
    Node head = null;
    head = insertBegin(head, 50);
    head = insertBegin(head, 40);
    head = insertBegin(head, 30);
    head = insertBegin(head, 20);
    head = insertBegin(head, 10);
    head = sortedInsert(head, 35);
    middle(head);
    nthNodeFromEnd(head, 3);
    head = reverse(head);
    head = recursiveReverse(head);
    head = insertEnd(head, 50);
    head = removeDuplicates(head);
    head = reverseInGroups(head, 3);
    boolean loop2 = detectLoopOptimized(head);
    boolean loop3 = detectLoopFloydCycleAlgo(head);
    // boolean loop = detectLoop(head);
    System.out.println("Loop present : " + loop2);
    // detectAndRemoveLoop(head);
    deleteRandomNodeWithoutHeadNode(head.next);
    // head = segregateEvenOdd(head);
    printList(head);
    head = pairWiseSwap(head);
    printList(head);
  }

  private static Node pairWiseSwap(Node head) {
    Node curr = head;
    while (curr != null && curr.next != null) {
      swapNodes(curr, curr.next);
      curr = curr.next.next;
    }
    return head;
  }

  private static void swapNodes(Node curr, Node next) {
    int temp = curr.data;
    curr.data = next.data;
    next.data = temp;
  }

  private static Node segregateEvenOdd(Node head) {
    Node eS = null, eE = null, oS = null, oE = null;
    for (Node curr = head; curr != null; curr = curr.next) {
      int x = curr.data;
      if (x % 2 == 0) {
        if (eS == null) {
          eS = curr;
          eE = eS;
        } else {
          eE.next = curr;
          eE = eE.next;
        }
      } else {
        if (oS == null) {
          oS = curr;
          oE = oS;
        } else {
          oE.next = curr;
          oE = oE.next;
        }
      }
    }
    if (oS == null || eS == null) return head;
    eE.next = oS;
    oE.next = null;
    return eS;
  }

  private static void deleteRandomNodeWithoutHeadNode(Node node) {
    node.data = node.next.data;
    node.next = node.next.next;
  }

  private static Node detectAndRemoveLoop(Node head) {
    Node slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) break;
    }
    slow = head;
    while (slow.next != fast.next) {
      slow = slow.next;
      fast = fast.next;
    }
    fast.next = null;
    return head;
  }

  private static boolean detectLoopFloydCycleAlgo(Node head) {
    Node slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) return true;
    }
    return false;
  }

  private static boolean detectLoopOptimized(Node head) {
    HashSet<Node> s = new HashSet();
    Node cur = null;
    for (cur = head; cur != null; cur = cur.next) {
      if (s.contains(cur)) return true;
      s.add(cur);
    }
    return false;
  }

  private static boolean detectLoop(Node head) {
    Node temp = null;
    Node curr = head;
    while (curr != null) {
      if (curr.next == null) return false;
      if (curr.next == temp) return true;
      Node curr_next = curr.next;
      curr.next = temp;
      curr = curr.next;
    }
    return false;
  }

  private static Node reverseInGroups(Node head, int k) {
    Node curr = head, next = null, prev = null;
    int count = 0;
    while (curr != null && count < k) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
      count++;
    }
    if (next != null) {
      Node rest_head = reverseInGroups(next, k);
      head.next = rest_head;
    }
    return prev;
  }

  private static Node removeDuplicates(Node head) {
    Node curr = head;
    while (curr != null && curr.next != null) {
      if (curr.data == curr.next.data) curr.next = curr.next.next;
      else curr = curr.next;
    }
    return head;
  }

  private static Node recursiveReverse(Node head) {
    if (head == null || head.next == null) return head;
    Node rest_head = recursiveReverse(head.next);
    Node rest_tail = head.next;
    rest_tail.next = head;
    head.next = null;
    return rest_head;
  }

  private static Node reverse(Node head) {
    Node curr = head;
    Node prev = null;
    while (curr != null) {
      Node next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  private static void nthNodeFromEnd(Node head, int n) {
    if (head == null) return;
    Node first = head;
    for (int i = 0; i < n; i++) {
      if (first == null) return;
      first = first.next;
    }
    Node second = head;
    while (first != null) {
      second = second.next;
      first = first.next;
    }
    System.out.println(n + "th element from end : " + second.data);
  }

  private static void middle(Node head) {
    if (head == null) return;
    Node slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    System.out.println("Middle elt : " + slow.data);
  }

  private static Node sortedInsert(Node head, int e) {
    Node temp = new Node(e);
    if (head == null) return temp;
    if (e < temp.data) {
      temp.next = head;
      return temp;
    }
    Node curr = head;
    while (curr.next != null && curr.next.data < e) curr = curr.next;
    temp.next = curr.next;
    curr.next = temp;
    return head;
  }
}
