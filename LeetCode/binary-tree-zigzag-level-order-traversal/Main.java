题目描述

Given a binary tree, return the zigzag level ordertraversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
For example:
Given binary tree{3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (root == null){
            return ret;
        }
        
        int level = 1;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()){
            ArrayList<Integer> list = new ArrayList<Integer>();
            if ((level & 1) == 1){
                while(!s1.isEmpty()){
                    TreeNode t = s1.pop();
                    list.add(t.val);
                    if (t.left != null){
                        s2.push(t.left);
                    }
                    if (t.right != null){
                        s2.push(t.right);
                    }
                }
            }else{
                while(!s2.isEmpty()){
                    TreeNode t = s2.pop();
                    list.add(t.val);
                    if (t.right != null){
                        s1.push(t.right);
                    }
                    if (t.left != null){
                        s1.push(t.left);
                    }
                    
                }
            }
            level++;
            ret.add(new ArrayList<>(list));
        }
        return ret;
    }
}