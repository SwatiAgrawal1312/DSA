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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        solver(root,result);
        return result;
        
    }
    public static void solver(TreeNode root,List<Integer> result){
        if(root==null){
            return;
        }
        solver(root.left,result);
        
        solver(root.right,result);
        result.add(root.val);
    }
}