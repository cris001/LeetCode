题目描述

Given a singly linked list L: L 0→L 1→…→L n-1→L n,
reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
You must do this in-place without altering the nodes' values.
For example,
Given{1,2,3,4}, reorder it to{1,4,2,3}.
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null){
            return;
        }
        if (head.next == null){
            return;
        }
        if (head.next != null && head.next.next == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode p = slow.next;
        slow.next = null;//important
        ListNode t = null;
        while(p != null){
            ListNode node = p.next;
            p.next = t;
            t = p;
            p = node;
        }
        //t is start of the right partition
        ListNode h = head;
        while(h != null && t != null){
            ListNode tmp1 = h.next;
            ListNode tmp2 = t.next;
            t.next = tmp1;
            h.next = t;
            t = tmp2;
            h = tmp1;
        }
        return;
    }
}