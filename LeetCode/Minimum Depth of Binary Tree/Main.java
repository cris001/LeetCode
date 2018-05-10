题目描述
Given a binary tree, find its minimum depth.The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
public class Solution {
    public int run(TreeNode root) {
        return getMinDepth(root,false);
    }
    public int getMinDepth(TreeNode root,boolean hasBrother){
        if (root == null){
            if (hasBrother){
                return Integer.MAX_VALUE;
            }else{
                return 0;
            }
        }
        
        return Math.min(getMinDepth(root.left, root.right != null),
                        getMinDepth(root.right, root.left != null)) + 1;
    }
}