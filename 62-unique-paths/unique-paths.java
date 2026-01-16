class Solution {
    int dp[][];
    public int uniquePaths(int m, int n) {
        dp=new int[m+1][n+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,0,m,n);
        
    }
    public int solve(int i,int j,int m,int n){
        if(i==m || j==n){
            return 0;
        }
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int x=solve(i+1,j,m,n);
        int y=solve(i,j+1,m,n);
        return dp[i][j]=x+y;
        
    }
}
