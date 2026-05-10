class Solution {
    int dp[][];
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dp=new int[100][100];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(obstacleGrid,0,0);
        
    }
    public int helper(int[][] obstacleGrid,int i,int j){
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(i>=m || j>=n){
            return 0;
        }
        if(obstacleGrid[i][j]==1){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(i==m-1&& j==n-1){
            return 1;
        }
        
        
        int down=helper(obstacleGrid,i+1,j);
        int right=helper(obstacleGrid,i,j+1);
        return dp[i][j]=down+right;
    }
}