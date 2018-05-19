题目描述

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
For example:
Given the below binary tree andsum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]

import java.util.*;
public class Solution {
    ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null){
            return ret;
        }
        list.add(root.val);
        dfs(root,sum-root.val);
        return ret;
    }
    public void dfs(TreeNode root,int sum){
        if (root == null){
            return;
        }
        if (sum == 0 && root.left == null && root.right == null){
            ret.add(new ArrayList<>(list));
            return;
        }
        
        if (root.left != null){
            list.add(root.left.val);
            dfs(root.left, sum-root.left.val);
            list.remove(list.size()-1);
        }
        if (root.right != null){
            list.add(root.right.val);
            dfs(root.right, sum-root.right.val);
            list.remove(list.size()-1);
        }
    }
}