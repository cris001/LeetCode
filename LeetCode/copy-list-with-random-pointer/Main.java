题目描述

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
Return a deep copy of the list.
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null){
            return null;
        }
        RandomListNode p = new RandomListNode(-1);
        RandomListNode q = new RandomListNode(head.label);
        p.next = q;
        RandomListNode t = head;
        while(head.next != null){
            p.next = new RandomListNode(head.next.label);
            if (head.random != null){
                p.random = new RandomListNode(head.random.label);
            }
            p = p.next;
            head = head.next;
        }
        
        return t;
    }
}