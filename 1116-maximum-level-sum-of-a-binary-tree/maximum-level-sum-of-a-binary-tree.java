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
    public int maxLevelSum(TreeNode root) {
        
        int max=Integer.MIN_VALUE;
        int level=1;
        int ans=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int qsise=q.size();
            int sum=0;
            for(int i=0;i<qsise;i++){
                TreeNode  x=q.poll();
                sum+=x.val;
                if(x.left!=null) q.add(x.left);
                if(x.right!=null) q.add(x.right);

            }
            if(max<sum){
                max=sum;
                ans=level;

            }
            level++;

        }
        return ans;

        
    }
}