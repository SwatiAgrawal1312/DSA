class Solution {
    Boolean dp[];
    public boolean wordBreak(String s, List<String> wordDict) {
        dp=new Boolean[s.length()];
        HashSet<String> set=new HashSet<>();
       for(String word:wordDict){
        set.add(word);
        }
        return solver(0,s,set);
    }
    public boolean solver(int idx,String s,HashSet<String> set){
        if(idx==s.length()){
            return true;
        }
        if(dp[idx]!=null){
            return dp[idx];
        }
        for(int l=1;idx+l<=s.length();l++){
            String temp=s.substring(idx,idx+l);
            if(set.contains(temp)){
                if(solver(idx+l,s,set)){
                    return dp[idx]= true;
                }
            }
        }
        return dp[idx]=false;
        
    }
}