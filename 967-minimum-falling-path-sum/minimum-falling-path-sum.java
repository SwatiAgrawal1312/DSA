class Solution {
    int m,n;
    int dp[][];
    public int minFallingPathSum(int[][] matrix) {
        m=matrix.length;
        n=matrix[0].length;
        dp=new int[101][101];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=Integer.MIN_VALUE;
            }
        }
        int mini=Integer.MAX_VALUE;
        for(int c=0;c<matrix[0].length;c++){
           
            mini=Math.min(mini,helper(matrix,0,c));
        }
        return mini;
        
    }
    public int helper(int[][] matrix,int row,int c){
        if(c<0 || c>=n ){
            return Integer.MAX_VALUE;
        }
        if(row==m-1){
            return matrix[row][c];
        }
        if(dp[row][c]!=Integer.MIN_VALUE){
            return dp[row][c];
        }
        int x=helper(matrix,row+1,c-1);
        int y=helper(matrix,row+1,c);
        int z=helper(matrix,row+1,c+1);
        return dp[row][c]=matrix[row][c]+Math.min(x,Math.min(y,z));
    }
}