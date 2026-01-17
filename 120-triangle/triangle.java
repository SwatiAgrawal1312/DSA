class Solution {
    int n;
    int dp[][];
    public int minimumTotal(List<List<Integer>> triangle) {
        n=triangle.size();
        dp=new int[201][201];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<=i;j++){
                dp[i][j]=Integer.MIN_VALUE;
            }
        }
        return solve(triangle,0,0);
    }
    public int solve(List<List<Integer>> triangle,int row ,int col){
        if(row==n-1){
            return triangle.get(row).get(col);
        }
        if(dp[row][col]!=Integer.MIN_VALUE){
            return dp[row][col];
        }
        int x=solve(triangle,row+1,col);
        int y=solve(triangle,row+1,col+1);
        return dp[row][col]=triangle.get(row).get(col)+Math.min(x,y);

    }
}