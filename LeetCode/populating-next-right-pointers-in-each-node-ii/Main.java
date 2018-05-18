题目描述

Follow up for problem "Populating Next Right Pointers in Each Node".
What if the given tree could be any binary tree? Would your previous solution still work?
Note:
You may only use constant extra space.

For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7

After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
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
            for(int i = 0;i<n;i++){
                TreeLinkNode t = queue.poll();
                if (t.left != null){
                    queue.add(t.left);
                }
                if (t.right != null){
                    queue.add(t.right);
                }
                if (i < n - 1){
                    t.next = queue.peek();
                }else{
                    t.next = null;
                }
            }
        }
    }
}