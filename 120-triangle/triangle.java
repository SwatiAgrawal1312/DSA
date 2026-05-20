class Solution {
    int dp[][]=new int[201][201];
    
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int rows[]:dp){
        Arrays.fill(rows,Integer.MIN_VALUE);
        }
        
        return solve(triangle,0,0);
    }
    public int solve(List<List<Integer>> triangle,int i ,int j){
        if(i==triangle.size()-1){
            return triangle.get(i).get(j);
        }
         if(dp[i][j]!=Integer.MIN_VALUE){
            return dp[i][j];
         }
        int x=solve(triangle,i+1,j);
        int y=solve(triangle,i+1,j+1);
        return dp[i][j]=triangle.get(i).get(j)+Math.min(x,y);
       

    }
}