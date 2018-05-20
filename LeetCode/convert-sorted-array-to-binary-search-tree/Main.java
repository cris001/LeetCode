题目描述

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0){
            return null;
        }
        return convertToBST(num,0,num.length-1);
    }
    
    public TreeNode convertToBST(int[] num,int l,int r){
        if (l > r){
            return null;
        }
        if (l == r){
            TreeNode root = new TreeNode(num[l]);
            return root;
        }
        int mid = l + ((r -l) >> 1);
        if (((r - l + 1) & 1) == 0){
            mid += 1;
        }
        TreeNode root = new TreeNode(num[mid]);
        root.left = convertToBST(num,l,mid - 1);
        root.right = convertToBST(num,mid + 1,r);
        return root;
    }
}