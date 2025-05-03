public class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

final class Solution {
  /**
   * Adds two numbers represented as reversed linked lists and returns the sum as
   * a new reversed linked list.
   * Each node contains a single digit. The returned list is a new instance, not a
   * mutation of the input.
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    final var dummyHead = new ListNode(0);
    var current = dummyHead;
    var carry = 0;
    var pAugend = l1;
    var pAddend = l2;
    while (pAugend != null || pAddend != null || carry != 0) {
      final var digitAugend = (pAugend != null) ? pAugend.val : 0;
      final var digitAddend = (pAddend != null) ? pAddend.val : 0;
      final var sum = digitAugend + digitAddend + carry;
      carry = sum / 10;
      current.next = new ListNode(sum % 10);
      current = current.next;
      pAugend = (pAugend != null) ? pAugend.next : null;
      pAddend = (pAddend != null) ? pAddend.next : null;
    }
    return dummyHead.next;
  }
}
