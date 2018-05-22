题目描述

Two elements of a binary search tree (BST) are swapped by mistake.
Recover the tree without changing its structure.
import java.util.*;
public class Solution {
    ArrayList<TreeNode> list = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        inOrderTraverse(root);
        TreeNode a = root;
        TreeNode b = root;
        for(int i = 1;i<list.size();i++){
            if (list.get(i).val < list.get(i-1).val){
                a = list.get(i-1);
                break;
            }
        }
        for(int i = list.size() - 1;i>=1;i--){
            if (list.get(i).val < list.get(i-1).val){
                b = list.get(i);
                break;
            }
        }
        int t = a.val;
        a.val = b.val;
        b.val = t;
    }
    
    public void inOrderTraverse(TreeNode root){
        if (root == null){
            return;
        }
        inOrderTraverse(root.left);
        list.add(root);
        inOrderTraverse(root.right);
    }
}