题目描述

Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keysless than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        if (root.left == null && root.right == null){
            return true;
        }
        boolean left = true;
        if (root.left != null){
            TreeNode max = root.left;
            while(max.right != null){
                max = max.right;
            }
            left = root.val > max.val && isValidBST(root.left);
        }
        boolean right = true;
        if (root.right != null){
            TreeNode min = root.right;
            while(min.left != null){
                min = min.left;
            }
            right = root.val < min.val && isValidBST(root.right);
        }
        return left && right;
    }
}