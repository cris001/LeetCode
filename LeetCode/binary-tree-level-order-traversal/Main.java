题目描述

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
For example:
Given binary tree{3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (root == null){
            return ret;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        TreeNode last = root;
        TreeNode now = root;
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
            if (last == t){
                ret.add(new ArrayList<>(list));
                list.clear();
                last = now;
            }
        }
        return ret;
    }
}