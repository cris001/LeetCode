题目描述

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.
For example,
Given this linked list:1->2->3->4->5
For k = 2, you should return:2->1->4->3->5
For k = 3, you should return:3->2->1->4->5
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k<=1){
            return head;
        }
        int n = getLength(head);
        ListNode p = new ListNode(-1);
        p.next = head;
        ListNode t = p;
        ListNode cur = head;
        ListNode pre = p;
        for(int i = 1;i<=n/k;i++){
            for(int j = 1;j<=k-1;j++){
                ListNode node = cur.next;
                cur.next = node.next;
                node.next = pre.next;
                pre.next = node;
            }
            pre = cur;
            cur = cur.next;
        }
        return t.next;
    }
    
    public int getLength(ListNode head){
        int count = 0;
        ListNode p = head;
        while(p != null){
            p = p.next;
            count++;
        }
        return count;
    }
}