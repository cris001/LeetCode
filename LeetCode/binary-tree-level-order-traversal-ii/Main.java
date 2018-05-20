题目描述

Given a binary tree, return the bottom-up level ordertraversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
For example:
Given binary tree{3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:
[
  [15,7]
  [9,20],
  [3],
]
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (root == null){
            return ret;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode now = root;
        TreeNode last = root;
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode t = queue.poll();
            if (t.left != null){
                queue.add(t.left);
                now = t.left;
            }
            if (t.right != null){
                queue.add(t.right);
                now = t.right;
            }
            list.add(t.val);
            if (t == last){
                ret.add(0,new ArrayList<>(list) );
                last = now;
                list.clear();
            }
        }
        return ret;
    }
}