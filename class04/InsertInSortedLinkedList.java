/**
Insert In Sorted Linked List
Description
Insert a value in a sorted linked list.

Examples

L = null, insert 1, return 1 -> null
L = 1 -> 3 -> 5 -> null, insert 2, return 1 -> 2 -> 3 -> 5 -> null
L = 1 -> 3 -> 5 -> null, insert 3, return 1 -> 3 -> 3 -> 5 -> null
L = 2 -> 3 -> null, insert 1, return 1 -> 2 -> 3 -> null

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
  public ListNode insert(ListNode head, int value) {
      // Write your solution here
      //    x -> y -> z -> w -> null
      //   1    2            3
      //   c   c.next
      // case 1: head == null || target <= head.value  insert before the head
      // case 2: cur.next != null || cur.next.value >= value  insert between cur and cur.next
      ListNode newNode = new ListNode(value);
      if (head == null || head.value >= value) {
         newNode.next = head;
         return newNode;
      }
      ListNode cur = head;
      while (cur.next != null && cur.next.value < value) {
        cur = cur.next;
      }
      newNode.next = cur.next;
      cur.next = newNode;
      return head;
  }
}
