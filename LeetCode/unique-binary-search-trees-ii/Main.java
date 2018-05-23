题目描述

Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
For example,
Given n = 3, your program should return all 5 unique BST's shown below.
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
import java.util.*;
public class Solution {
    
    public ArrayList<TreeNode> generateTrees(int n) {
        return BSTtree(1,n);
    }
    
    public ArrayList<TreeNode> BSTtree(int l,int r){
        ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
        if (l > r){
            ret.add(null);
            return ret;
        }
        for(int i = l;i<=r;i++){
            ArrayList<TreeNode> left = BSTtree(l,i-1);
            ArrayList<TreeNode> right = BSTtree(i+1,r);
            for(int j = 0;j<left.size();j++){
                for(int k = 0;k<right.size();k++){
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(j);
                    root.right = right.get(k);
                    ret.add(root);
                }
            }
        }
        return ret;
    }
}