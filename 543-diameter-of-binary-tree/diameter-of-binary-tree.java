/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        diameterfind(root);
        return diameter;
       
        
    }
    public int diameterfind(TreeNode root){
        if(root==null){
            return 0;
        }
        int lefth=diameterfind(root.left);
        int righth=diameterfind(root.right);

        diameter=Math.max(diameter,lefth+righth);
        return 1+Math.max(lefth,righth);
    }
}