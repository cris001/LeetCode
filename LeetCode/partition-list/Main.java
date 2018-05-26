题目描述

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.
For example,
Given1->4->3->2->5->2and x = 3,
return1->2->2->4->3->5.
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null){
            return null;
        }
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(-1);
        ListNode p = l1;
        ListNode t = l2;
        while(head != null){
            if (head.val < x){
                p.next = head;
                p = head;
            }else{
                t.next = head;
                t = head;
            }
            head = head.next;
        }
        p.next = l2.next;
        t.next = null;
        return l1.next;
    }
}