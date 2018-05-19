题目描述

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null){
            return null;
        }
        return convertToBST(head,null);
    }
    
    public TreeNode convertToBST(ListNode head, ListNode end){
        if (head == end){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != end && fast.next != end){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = convertToBST(head,slow);
        root.right = convertToBST(slow.next,end);
        return root;
    }
}