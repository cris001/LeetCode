题目描述

Given a linked list, remove the n th node from the end of list and return its head.
For example,
   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null){
            return null;
        }
        int len = getLength(head);
        if (n > len){
            return null;
        }
        ListNode t = new ListNode(-1);
        t.next = head;
        ListNode p = t;
        for(int i = 1;i<=n;i++){
            t = t.next;
        }
        ListNode slow = p;
        while(t.next != null){
            t = t.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return p.next;
    }
    
    public int getLength(ListNode head){
        ListNode p = head;
        int count = 1;
        while(p != null){
            p = p.next;
            count++;
        }
        return count;
    }
}