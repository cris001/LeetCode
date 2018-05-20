题目描述

Given preorder and inorder traversal of a tree, construct the binary tree.
import java.util.;
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null  preorder.length == 0){
            return null;
        }
        if (preorder.length != inorder.length){
            return null;
        }
        int n = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        if (n == 1){
            return root;
        }
        int k = 0;
        for(int i = 0;in;i++){
            if (preorder[0] == inorder[i]){
                k = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder,1,k+1),Arrays.copyOfRange(inorder,0,k));
        root.right = buildTree(Arrays.copyOfRange(preorder,k+1,n),Arrays.copyOfRange(inorder,k+1,n));
        return root;
    }
}