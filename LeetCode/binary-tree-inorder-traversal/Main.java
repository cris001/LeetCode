题目描述

Given a binary tree, return the inorder traversal of its nodes' values.
For example:
Given binary tree{1,#,2,3},
   1
    \
     2
    /
   3

return[1,3,2].
import java.util.*;
public class Solution {
    ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return list;
    }
    
    public void inorder(TreeNode root){
        if (root == null){
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}