题目描述

Given a linked list, determine if it has a cycle in it.
Follow up:
Can you solve it without using extra space?
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }
}