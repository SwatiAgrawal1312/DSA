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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
        int level=0;
        while(!q.isEmpty()){
            int sz=q.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<sz;i++){
                TreeNode curr=q.poll();
                if(level%2!=0){
                    list.addFirst(curr.val);

                }else{
                    list.add(curr.val);

                }
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
            }
            level++;
            res.add(list);

        }
        return res;
        
        
    }
}