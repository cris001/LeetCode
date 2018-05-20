题目描述

Given inorder and postorder traversal of a tree, construct the binary tree.
import java.util.*;
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0){
            return null;
        }
        if (inorder.length != postorder.length){
            return null;
        }
        if (inorder.length != postorder.length){
            return null;
        }
        int n = postorder.length;
        TreeNode root = new TreeNode(postorder[n-1]);
        if (n == 1){
            return root;
        }
        int k = 0;
        for(int i = 0;i<n;i++){
            if (inorder[i] == postorder[n-1]){
                k = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(inorder,0,k),Arrays.copyOfRange(postorder,0,k));
        root.right = buildTree(Arrays.copyOfRange(inorder,k+1,n),Arrays.copyOfRange(postorder,k,n-1));
        return root;
    }
}