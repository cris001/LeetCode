题目描述

Given a linked list, return the node where the cycle begins. If there is no cycle, returnnull.
Follow up:
Can you solve it without using extra space?
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(slow != null && fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}