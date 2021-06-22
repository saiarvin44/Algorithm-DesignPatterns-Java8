package Algorithms.leetcodeAlgos.medium;

class ListNode {
  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

public class SplitALinkedList {
  public static void main(String[] args) {
    ListNode node =
        new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null)))));
    int k = 3;
    splitListToParts(node, k);
  }

  public static ListNode[] splitListToParts(ListNode root, int k) {
    ListNode start = root;
    int count = 0;
    while (start != null) {
      start = start.next;
      count++;
    }
    int mod = count % k;
    int n = count / k;
    System.out.print(n + " " + count + " " + mod);
    ListNode[] arr = new ListNode[k];

    if (n >= 1) {
      ListNode tempHead = root, write;
      write = new ListNode(tempHead.val);
      ListNode store = write;
      for (int i = 1; i < n + mod; i++) {
        if (tempHead.next != null) {
          tempHead = tempHead.next;
          write.next = new ListNode(tempHead.val);
          write = write.next;
        }
      }
      arr[0] = store;

      for (int i = 1; i < k; i++) {
        tempHead = tempHead.next;
        write = new ListNode(tempHead.val);
        store = write;
        for (int j = 1; j < n; j++) {
          if (tempHead.next != null) {
            tempHead = tempHead.next;
            write.next = new ListNode(tempHead.val);
            write = write.next;
          }
        }
        arr[i] = store;
      }
    } else {
      ListNode tempHead = root;
      for (int i = 0; i < k; i++) {
        if (tempHead != null) {
          arr[i] = new ListNode(tempHead.val);
          tempHead = tempHead.next;
        } else arr[i] = null;
      }
    }
    return arr;
  }
}
