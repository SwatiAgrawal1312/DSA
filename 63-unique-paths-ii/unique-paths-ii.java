class Solution {
    int m,n;
    int dp[][];
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m=obstacleGrid.length;
        n=obstacleGrid[0].length;
        dp=new int[101][101];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
       
        return solve(obstacleGrid,0,0);
        
    }
    private int solve(int[][] obstacleGrid,int i,int j){
        if(i==m || j==n){
            return 0;
        }
        if(obstacleGrid[i][j]==1){
            return 0;
        }
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
       
        int x=solve(obstacleGrid,i+1,j);
        int y=solve(obstacleGrid,i,j+1);

        
        return dp[i][j]=x+y;
        
    }
}