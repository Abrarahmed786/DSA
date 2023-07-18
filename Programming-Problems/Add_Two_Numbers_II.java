// You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.


class Solution {
    private ListNode r(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode nextNode = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextNode;
    }
    return prev;
}
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    l1 = r(l1);
    l2 = r(l2);
  ListNode dummy = new ListNode(0);
    ListNode p = l1;
    ListNode q = l2;
    ListNode curr = dummy;
    int carry = 0;

    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int digitSum = carry + x + y;
        carry = digitSum / 10;
        curr.next = new ListNode(digitSum % 10);
        curr = curr.next;
        if (p != null) {
            p = p.next;
        }
        if (q != null) {
            q = q.next;
        }
    }

    if (carry > 0) {
        curr.next = new ListNode(carry);
    }

    ListNode result = r(dummy.next);

    return result;
}


}