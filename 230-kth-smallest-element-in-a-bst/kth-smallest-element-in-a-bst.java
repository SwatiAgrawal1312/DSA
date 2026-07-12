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
    int pos=0;
    public int kthSmallest(TreeNode root, int k) {
       TreeNode ans=solver(root,k);
       if(ans==null){
        return -1;
       }
       return ans.val;
       
    }
    public TreeNode solver(TreeNode root,int k){
        if(root==null){
            return root;
        }
        TreeNode left=solver(root.left,k);
        if(left!=null){
            return left;
        }
        pos++;
        if(k==pos){
            return root;
        }
        return solver(root.right,k);
        


    }
    
}