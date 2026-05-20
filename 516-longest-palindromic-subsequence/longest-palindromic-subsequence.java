class Solution {
    int dp[][]=new int[1001][1001];
    public int longestPalindromeSubseq(String s) {
       

        String t=new StringBuilder(s).reverse().toString();
        
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
       
        return solver(s,t,0,0);
        
    }
    public int solver(String s,String t,int i,int j){
        int m=s.length();
        int n=t.length();
        if(i>=m || j>=n){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=1+solver(s,t,i+1,j+1);
        }
        int inc_i=solver(s,t,i+1,j);
        int inc_j=solver(s,t,i,j+1);
        return dp[i][j]=Math.max(inc_i,inc_j);
    }
}