package Algorithms.leetcodeAlgos.curatedAlgos;

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

class OddEvenLinkedList {
  public static void main(String[] args) {
    ListNode node =
        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));

    oddEvenList(node);
  }

  public static ListNode oddEvenList(ListNode head) {
    ListNode curr = head;
    int count = 0;
    while (curr != null) {
      count++;
      curr = curr.next;
    }
    int[] arr = new int[count];
    int odd = -1, even = 0;
    ListNode calc = head;
    int c = 0;
    while (calc != null) {
      arr[c++] = calc.val;
      calc = calc.next;
    }
    for (even = 0; even < count; even++) {
      if (arr[even] % 2 == 1) {
        odd++;
        int temp = arr[odd];
        arr[odd] = arr[even];
        arr[even] = temp;
      }
    }

    ListNode ans = new ListNode(arr[0]);
    ListNode finalAns = ans;
    for (int i = 1; i < count; i++) {
      ans.next = new ListNode(arr[i]);
      ans = ans.next;
    }
    return finalAns;
  }
}
