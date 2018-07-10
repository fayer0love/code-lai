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
