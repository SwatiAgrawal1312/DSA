class Solution {
    int n;
    int dp[][];
    public int longestPalindromeSubseq(String s) {
        n=s.length()-1;
        dp=new int[1001][1001];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp.length;j++){
                if(i==j){
                    dp[i][j]= 1;
                }else{
                    dp[i][j]=1000;
                }
            }
        }
        return helper(s,0,n);
        
    }
    public int helper(String s,int i,int j){
        if(i==j){
            return 1;
        }
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=1000){
            return dp[i][j];
        }
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=2+helper(s,i+1,j-1);
        }else{
            return dp[i][j]=Math.max(helper(s,i+1,j),helper(s,i,j-1));
        }
        
    }
}