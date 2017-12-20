题目描述

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
For example,
Given1->2->3->3->4->4->5, return1->2->5.
Given1->1->1->2->3, return2->3.
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode p = new ListNode(-1);
        ListNode t = p;
        while(head != null){
            int val = head.val;
            boolean flag = false;
            while(head.next != null && head.next.val == val){
                flag = true;
                head = head.next;
            }
            if (!flag){
                t.next = head;
                t = head;
            }
            head = head.next;
        }
        t.next = null;
        return p.next;
    }
}