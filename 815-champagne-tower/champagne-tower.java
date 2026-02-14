class Solution {
    double dp[][];
    
    public double champagneTower(int poured, int query_row, int query_glass) {
        dp=new double[101][101];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        
        return Math.min(1.0,helper(poured,query_row,query_glass));
        
    }
    public double helper(int poured, int i, int j){
        if(i<0||j<0||j>i){
            return 0.0;
        }
        if(i==0 && j==0){
            return poured;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        double x=(helper(poured,i-1,j-1)-1)/2.0;
        double y=(helper(poured,i-1,j)-1)/2.0;
        if(x<0){
            x=0.0;
        }
        if(y<0){
            y=0.0;
        }
        return dp[i][j]=x+y;
        

    }
    
    
}