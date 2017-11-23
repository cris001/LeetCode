题目描述

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        if (l1 != null && l2 == null){
            return l1;
        }
        if (l1 == null && l2 != null){
            return l2;
        }
        ListNode p = new ListNode(-1);
        ListNode t = p;
        while(l1!=null && l2 != null){
            if (l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null){
            p.next = l1;
        }
        if (l2 != null){
            p.next = l2;
        }
        return t.next;
    }
}