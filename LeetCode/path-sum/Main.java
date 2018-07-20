题目描述
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
For example:
Given the below binary tree andsum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path5->4->11->2which sum is 22.

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        return dfs(root,sum - root.val);
    }
    
    public boolean dfs(TreeNode root,int sum){
        if (sum == 0 && root.left == null && root.right == null){
            return true;
        }
        boolean l = false;
        boolean r = false;
        if (root.left != null){
            l = dfs(root.left,sum-root.left.val);
        }
        if (root.right != null){
            r = dfs(root.right,sum-root.right.val);
        }
        return l || r;
    }
}