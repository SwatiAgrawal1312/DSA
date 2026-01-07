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
    long maxpro=0;
    int MOD = 1_000_000_007;
    
    int tsum=0;
    public int maxProduct(TreeNode root) {
        tsum=totalsum(root);
        largestmaximumproduct(root);
        return (int)(maxpro%MOD);
        }
    private int largestmaximumproduct(TreeNode root){
        if (root == null) return 0;

        int lsum = largestmaximumproduct(root.left);
        int rsum = largestmaximumproduct(root.right);

        int x = lsum + rsum + root.val;   // ✅ subtree sum

        long product = (long)x * (tsum - x);
        maxpro = Math.max(maxpro, product);

        return x;   // ✅ 
    }
    private int totalsum(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=totalsum(root.left);
        int r=totalsum(root.right);
        int s=l+r+root.val;
        return s;

    }
}