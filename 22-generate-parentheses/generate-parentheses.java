class Solution {
    List<String> res=new ArrayList<>();
    
    
    
    public List<String> generateParenthesis(int n) {
       
        helper("",0,0,n);
        return res;
        }
        public void helper(String curr,int open,int close ,int n){
        if(curr.length()==2*n){
           res.add(curr);
           return;
            }
           
        
        if(open<n){
          helper(curr+"(",open+1,close,n);
        } 
        if(close<open){
           helper(curr+")",open,close+1,n);
        } 
       
       }
    }