题目描述

Given a linked list, swap every two adjacent nodes and return its head.
For example,
Given1->2->3->4, you should return the list as2->1->4->3.
Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode p = new ListNode(-1);
        p.next = head.next;
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode k = new ListNode(-1);
        while(pre != null && cur != null){
            ListNode t = cur.next;
            k.next = cur;
            pre.next = t;
            cur.next = pre;
            k = pre;
            pre = t;
            if (t != null){
                cur = t.next;
            }
        }
        return p.next;
    }
}