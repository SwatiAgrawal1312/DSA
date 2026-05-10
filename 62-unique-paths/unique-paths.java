class Solution {
    int dp[][];
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        return helper(m,n,0,0);
        
    }
    public int helper(int m, int n,int i,int j){
        // corner cases
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(i==m||j==n){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down=helper(m,n,i+1,j);
        int right=helper(m,n,i,j+1);
        return dp[i][j]=down+right;
    }
}