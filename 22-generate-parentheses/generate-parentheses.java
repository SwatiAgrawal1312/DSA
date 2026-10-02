class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        solve("",n,res);
        return res;
        
    }
    public void solve(String curr,int n,List<String> res){
        if(curr.length()==2*n){
            if(is_valid(curr)){
                res.add(curr);
            }
            return;
        }
        solve(curr+'(',n,res);
        solve(curr+')',n,res);

    }
    public boolean is_valid(String s){
        int count=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                count++;
            }else{
                count--;
            }
            if(count<0){
                return false;
            }
        }
        return count==0;
    }
}