class Solution {
    int n,m;
    int dp[][];
    public int minDistance(String word1, String word2) {
        dp=new int[501][501];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);

        }
       
       
        n=word1.length();
        m=word2.length();
        return solve(word1,word2,0,0);
        
    }
    public int solve(String word1, String word2,int i,int j){
       
        if(i==n){
            return m-j;
        }
        if(j==m){
            return n-i;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(word1.charAt(i)==word2.charAt(j)){
            dp[i][j]=solve(word1,word2,i+1,j+1);
        }else{
        int x=1+solve(word1,word2,i+1,j);
        int y=1+solve(word1,word2,i,j+1);
        dp[i][j]=Math.min(x,y);
        }
        return dp[i][j];
    
    }
}