题目描述

Reverse a linked list from position m to n. Do it in-place and in one-pass.
For example:
Given1->2->3->4->5->NULL, m = 2 and n = 4,
return1->4->3->2->5->NULL.
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null){
            return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        for(int i=1;i<=m-1;i++){
            pre=pre.next;
        }
        ListNode t = new ListNode(-1);
        t.next = head;
        for(int i=0;i<=n;i++){
            t=t.next;
        }
        ListNode node = reverse(pre,t);
        if (m == 1){
            return node;
        }
        return head;
    }
    
    public ListNode reverse(ListNode pre, ListNode end){
        ListNode p = pre.next;
        ListNode t = end;
        //t.next = end;
        while(p != end){
            ListNode ne = p.next;
            p.next = t;
            t = p;
            p = ne;
        }
        pre.next = t;
        return t;
    }
}