/**
Reverse Linked List
Description
Reverse a singly-linked list.

Examples

L = null, return null
L = 1 -> null, return 1 -> null
L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null

 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
 
public class Solution {

  public ListNode reverse(ListNode head) {
    return reverseRecur(head);
  }

  public ListNode reverseIter(ListNode head) {
    // Write your solution here
    if (head == null || head.next == null) return head;
    //         a -> b -> c -> d
    //                       pre<-cur  next
    //
    ListNode pre = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = pre;
      pre = head;
      head = next;
    }
    return pre;
  }

  // recursion
  // 1. generally -> function call it self
  // 2. problem -> small size of problem
  // 3. base case -> recursion rule
  // base case
  //          x -> y -> z -> w
  // null <-  x <-| y z w |
  //               nh

  public ListNode reverseRecur(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode cur = head.next;
    ListNode newhead = reverseRecur(head.next);
    cur.next = head;
    head.next = null;
    return newhead;
  }

}
