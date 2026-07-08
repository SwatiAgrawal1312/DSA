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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        maxpath(root);
        return max;
    }
    public int maxpath(TreeNode root){
        if(root==null){
            return 0;
        }
        int x=Math.max(0,maxpath(root.left));
        int y=Math.max(0,maxpath(root.right));
        int z=root.val;
        max=Math.max(max,x+y+z);
        return z+(Math.max(x,y));
        
    }
}