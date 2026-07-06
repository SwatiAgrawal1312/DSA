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
        int ans=checkBalanced(root);
        return ans==-1?false:true;
       
    }
    public int checkBalanced(TreeNode root){
        if(root==null){
            return 0;
        }
        int x=checkBalanced(root.left);
        if(x==-1){
            return -1;
        }
        int y=checkBalanced(root.right);
        if(y==-1){
            return -1;
        }
        int diff=Math.abs(x-y);
        if(diff>1){
            return -1;
        }
        
        return 1+Math.max(x,y);

    }
}