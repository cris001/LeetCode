题目描述

Given a list, rotate the list to the right by k places, where k is non-negative.
For example:
Given1->2->3->4->5->NULLand k =2,
return4->5->1->2->3->NULL.
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null){
            return null;
        }
        int len = getLength(head);
        n = n % len;
        if (n == 0){
            return head;
        }
        ListNode p = head;
        for(int i = 1;i<(len - n);i++){
            p = p.next;
        }
        ListNode h = p.next;
        ListNode t = p.next;
        p.next = null;
        for(int i = 1;i<n;i++){
            h = h.next;
        }
        if (h != null){
            h.next = head;
        }
        return t;
    }
    
    public int getLength(ListNode head){
        if (head == null){
            return 0;
        }
        int len = 0;
        ListNode p = head;
        while(p!=null){
            len++;
            p = p.next;
        }
        return len;
    }
}