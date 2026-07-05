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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res; 
        }

        
        TreeMap<Integer,TreeMap<Integer,List<Integer>>> map=new TreeMap<>();
        dfs(root,map,0,0);

        for(Map.Entry<Integer,TreeMap<Integer,List<Integer>>> entry:map.entrySet()){
        TreeMap<Integer,List<Integer>> levelmap=entry.getValue();
        List<Integer> l=new ArrayList<>();
        for(Map.Entry<Integer,List<Integer>> subEntry:levelmap.entrySet()){
            List<Integer> sublist=subEntry.getValue();
            Collections.sort(sublist);
            l.addAll(sublist);
        }
        res.add(l);
        }
        return res;
    }
    public void dfs(TreeNode root,TreeMap<Integer,TreeMap<Integer,List<Integer>>> map,int col,int row){
        if(root==null){
            return;
        }
        if(!map.containsKey(col)){
            map.put(col,new TreeMap<>());
        }
        if(!map.get(col).containsKey(row)){
            map.get(col).put(row,new ArrayList<>());
        }
        map.get(col).get(row).add(root.val);
        dfs(root.left,map,col-1,row+1);
        dfs(root.right,map,col+1,row+1);


    }
}