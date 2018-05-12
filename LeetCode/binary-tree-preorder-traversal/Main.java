题目描述

Given a binary tree, return the preorder traversal of its nodes' values.
import java.util.*;
public class Solution {
    ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return list;
    }
    public void preorder(TreeNode root){
        if (root == null){
            return;
        }
        list.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}