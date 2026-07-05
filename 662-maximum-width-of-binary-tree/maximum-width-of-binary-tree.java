class Solution {

    private int maxWidth = 0;
    private List<Long> leftMost = new ArrayList<>();

    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0, 0L);
        return maxWidth;
    }

    private void dfs(TreeNode node, int depth, long index) {

        if (node == null) {
            return;
        }

        
        if (depth == leftMost.size()) {
            leftMost.add(index);
        }

        
        maxWidth = Math.max(maxWidth,
                (int)(index - leftMost.get(depth) + 1));

        
        dfs(node.left, depth + 1, 2 * index + 1);
        dfs(node.right, depth + 1, 2 * index + 2);
    }
}