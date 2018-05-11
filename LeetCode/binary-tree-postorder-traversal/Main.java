题目描述

Given a binary tree, return the postorder traversal of its nodes' values.
For example:
Given binary tree{1,#,2,3},
   1
    \
     2
    /
   3

return[3,2,1].
import java.util.*;
public class Solution {
    ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if (root == null){
            return list;
        }
        postorder(root);
        return list;
    }
    public void postorder(TreeNode root){
        if (root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        list.add(root.val);
    }
}