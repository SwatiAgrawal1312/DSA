class Solution {
    List<String> res=new ArrayList<>();
    
    public void helper(String curr,int n){
        if(curr.length()==2*n){
            if(isValid(curr)){
                res.add(curr);
            }
           return;
        }
        helper(curr+"(",n);
        helper(curr+")",n);
       }
    public boolean isValid(String curr){
       
        int count=0;
        for(int i=0;i<curr.length();i++){
            char ch=curr.charAt(i);
            if(ch=='('){
                count++;
            }else {
                count--;
                if(count<0){
                    return false;
                }
            }
            
        }
        return count==0;
    }
    public List<String> generateParenthesis(int n) {
       
        helper("",n);
        return res;
        }
    }