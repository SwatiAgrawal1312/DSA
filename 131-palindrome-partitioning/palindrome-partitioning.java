class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        helper(s,0,new ArrayList<>(),res);
        return res;
        
    }
    public void helper(String s,int idx,List<String> curr,List<List<String>> res){
        if(idx==s.length()){
            res.add(new ArrayList<>(curr));
            return;

        }

        for(int i=idx;i<s.length();i++){
            if(checkPalindrome(s,idx,i)){
            curr.add(s.substring(idx,i+1));
            helper(s,i+1,curr,res);
            curr.remove(curr.size()-1);
            }
           

        }
    }
    public boolean checkPalindrome(String s,int idx,int i){
        int p=idx;
        int t=i;
        while(p<=t){
            if(s.charAt(p)!=s.charAt(t)){
                return false;
            }
            p++;
            t--;

        }
        return true;
    }
}