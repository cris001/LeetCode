题目描述

Sort a linked list using insertion sort.

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode h = new ListNode(-1); 
        h.next = head;
        ListNode p = head;
        while(p!=null && p.next != null){
            if (p.val <= p.next.val){
                p = p.next;
                continue;
            }
            ListNode t = h;
            while(t.next != null && t.next.val <= p.next.val){
                t = t.next;
            }
            ListNode q = p.next;
            p.next = p.next.next;
            q.next = t.next;
            t.next = q;
        }
        return h.next;
    }
}