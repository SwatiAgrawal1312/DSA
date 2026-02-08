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
    public boolean isBalanced(TreeNode root) {
        int h=helper(root);
        return h==-1?false:true;
        
    }
    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int x=helper(root.left);
        int y=helper(root.right);
        if(x==-1 || y==-1){
            return -1;
        }
        if(Math.abs(x-y)>1){
            return -1;

        }
        return Math.max(x,y)+1;
    }
}