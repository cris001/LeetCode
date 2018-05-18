题目描述

Given a binary tree
    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set toNULL.
Initially, all next pointers are set toNULL.
import java.util.*;
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null){
            return;
        }
        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            //TreeLinkNode t = queue.poll();
            for(int i = 0;i<=n-1;i++){
                TreeLinkNode t = queue.poll();
                if (t.left != null){
                    queue.add(t.left);
                }
                if (t.right != null){
                    queue.add(t.right);
                }
                if (n > 1){
                    t.next = queue.peek();
                }
                if (i == n-1){
                    t.next = null;
                }
            }
        }
    }
}