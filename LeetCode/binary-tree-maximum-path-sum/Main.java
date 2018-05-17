Given a binary tree, find the maximum path sum.
The path may start and end at any node in the tree.
For example:
Given the below binary tree,
       1
      / \
     2   3

Return6.
public class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        int sum = root.val;
        if (l>0){
            sum+=l;
        }
        if (r>0){
            sum+=r;
        }
        ans = Math.max(sum,ans);
        if (Math.max(l,r) > 0){
            return Math.max(l,r) + root.val;
        }
        return root.val;
    }
}