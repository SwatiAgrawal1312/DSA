class Solution {
    int m,n;
    int dp[][];
    
    public int minPathSum(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        dp=new int[m+1][n+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return solve(grid,0,0);
        
    }
    private int solve(int[][] grid,int i,int j){
        if(i>=m || j>=n){
            return Integer.MAX_VALUE;
        }
        if(i==m-1 && j==n-1){
            return grid[i][j];

        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int x=solve(grid,i+1,j);
        int y=solve(grid,i,j+1);
        return dp[i][j]=grid[i][j]+Math.min(x,y);
       
        
    }
}