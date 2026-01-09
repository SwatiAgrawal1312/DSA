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
    HashMap<Integer,Integer> hm=new HashMap<>();
    int maxdepth=0;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth(root,0);
        if (hm.isEmpty()) {   
            depth(root, 0);
        }
        return helper(root);
        
    }
    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }

        // if current node itself is at maximum depth
        if (hm.get(root.val) == maxdepth) {
            return root;
        }

        TreeNode l = helper(root.left);
        TreeNode r = helper(root.right);

        if (l != null && r != null) {
            return root;
        }

        return l != null ? l : r;
    }
    private void depth(TreeNode root,int d){
        if(root==null){
            return;
        }
        maxdepth=Math.max(maxdepth,d);
        hm.put(root.val,d);
       
        
        depth(root.left,d+1);
        depth(root.right,d+1);
        }
}