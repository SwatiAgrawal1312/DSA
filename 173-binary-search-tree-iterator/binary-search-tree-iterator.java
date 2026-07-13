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
class BSTIterator {
    int idx=-1;
     List<Integer> list=new ArrayList<>();
   public void check(TreeNode root,List<Integer> list){
    if(root==null){
        return ;
    }
    check(root.left,list);
    list.add(root.val);
    check(root.right,list);
   }
    public BSTIterator(TreeNode root) {
       
        check(root,list);
       
        
        
    }
    
    public int next() {
        idx++;
        return list.get(idx);


        
    }
    
    public boolean hasNext() {
       
        if(idx+1>=list.size()){
            return false;
        }
        return true;
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */