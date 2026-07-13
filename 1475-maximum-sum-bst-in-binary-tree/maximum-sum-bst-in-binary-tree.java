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

    int ans = 0;

    class NodeValue {
        boolean isBST;
        int min;
        int max;
        int sum;

        NodeValue(boolean isBST, int min, int max, int sum) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    public NodeValue dfs(TreeNode root) {

        if (root == null) {
            return new NodeValue(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeValue left = dfs(root.left);
        NodeValue right = dfs(root.right);

        if (left.isBST && right.isBST &&
            root.val > left.max &&
            root.val < right.min) {

            int sum = left.sum + right.sum + root.val;

            ans = Math.max(ans, sum);

            int min = Math.min(left.min, root.val);
            int max = Math.max(right.max, root.val);

            return new NodeValue(true, min, max, sum);
        }

       
        return new NodeValue(false, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }
}