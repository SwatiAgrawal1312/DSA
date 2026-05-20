class Solution {
    int dp[][]=new int[501][501];
    public int minDistance(String word1, String word2) {
        for(int rows[]:dp){
          Arrays.fill(rows,-1);
        }
        
        return solver(word1,word2,0,0);
        
    }
    public int solver(String word1, String word2,int i,int j){
        int m=word1.length();
        int n=word2.length();
        if(i==m){
          return n-j;
        }
        if(j==n){
            return m-i;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(word1.charAt(i)==word2.charAt(j)){
            return dp[i][j]=solver(word1,word2,i+1,j+1);
        }
        int insert=1+solver(word1,word2,i,j+1);
        int delete=1+solver(word1,word2,i+1,j);
        int replace=1+solver(word1,word2,i+1,j+1);
        return dp[i][j]=Math.min(insert,(Math.min(delete,replace)));
    }
}