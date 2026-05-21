class Solution {
    int dp[][]=new int[1001][1002];
    public int longestStrChain(String[] words) {
       
        Arrays.sort(words,(a,b)->(a.length()-b.length()));
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        return solver(words,0,-1);
        
    }
    public boolean check_predecessor(String first,String second){
        if(second.length()!=first.length()+1){
            return false;
        }
        int i=0;
        int j=0;
       while(i<first.length() && j<second.length()){
            if(first.charAt(i)==second.charAt(j)){
                i++;
                j++;

            }else{
                j++;
            }
        }
        return i==first.length();
    }
    public int solver(String[] words,int i,int prev){
        if(i==words.length){
            return 0;
        }
        int take=0;
        if(dp[i][prev+1]!=-1){
            return dp[i][prev+1];
        }
        if(prev==-1|| check_predecessor(words[prev],words[i])==true){
            take=1+solver(words,i+1,i);
        }
        int skip=solver(words,i+1,prev);
        return dp[i][prev+1]=Math.max(take,skip);
    }
    
}