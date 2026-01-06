/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        preorder(root,sb);
        return sb.toString().trim();

        
    }
    public void preorder(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("# ");
            return ;
        }
        sb.append(root.val).append(" ");
        preorder(root.left,sb);
        preorder(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()){
            return null;
        }
        String st[]=data.split("\\s+");
        Queue<String> q=new LinkedList<>();
        for(String s:st){
            q.add(s);
        }
        return Dserialize(q);
        
    }
    public TreeNode Dserialize( Queue<String> q){
        if(q.isEmpty()){
            return null;
        }
        String peek=q.poll();
      
        if(peek.equals("#")) return null;
        TreeNode root=new TreeNode(Integer.parseInt(peek));
        root.left=Dserialize(q);
        root.right=Dserialize(q);
        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;