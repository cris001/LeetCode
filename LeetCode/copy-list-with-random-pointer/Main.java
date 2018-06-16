题目描述

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
Return a deep copy of the list.
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null){
            return null;
        }
        RandomListNode p = new RandomListNode(-1);
        RandomListNode q = new RandomListNode(head.label);
        RandomListNode s = p;
        p.next = q;
        p = p.next;
        RandomListNode t = head;
        while(head != null){
            if (head.random != null){
                p.random = new RandomListNode(head.random.label);
            }
            if (head.next != null){
                p.next = new RandomListNode(head.next.label);
            }
            p = p.next;
            head = head.next;
        }
        
        return s.next;
    }
}