题目描述

Given a binary tree containing digits from0-9only, each root-to-leaf path could represent a number.
An example is the root-to-leaf path1->2->3which represents the number123.
Find the total sum of all root-to-leaf numbers.
For example,
    1
   / \
  2   3

The root-to-leaf path1->2represents the number12.
The root-to-leaf path1->3represents the number13.
Return the sum = 12 + 13 =25.
public class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null){
            return 0;
        }
        dfs(root,root.val);
        return sum;
    }
    public void dfs(TreeNode root, int now){
        if (root.left == null && root.right == null){
            sum +=now;
            return;
        }
        if (root.left != null){
            dfs(root.left,now * 10+root.left.val);
        }
        if (root.right != null){
            dfs(root.right,now * 10+root.right.val);
        }
    }
}