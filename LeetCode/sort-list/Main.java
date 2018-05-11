题目描述

Sort a linked list in O(n log n) time using constant space complexity.
public class Solution {
    public ListNode sortList(ListNode head) {
        quickSort(head,null);
        return head;
    }
    public void quickSort(ListNode head,ListNode end){
        if (head != end){
            ListNode p = partition(head);
            quickSort(head,p);
            quickSort(p.next,end);
        }
    } 
    public ListNode partition(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        int k = head.val;
        while(fast != null){
            if (fast.val < k){
                slow = slow.next;
                int t = fast.val;
                fast.val = slow.val;
                slow.val = t;
            }
            fast = fast.next;
        }
        int t = k;
        head.val = slow.val;
        slow.val = t;
        return slow;
    }
}