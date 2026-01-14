class Solution {
    int dp[];
    public int climbStairs(int n) {
        dp=new int[46];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        return solve(n);
    }

        public int solve(int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int step_1=solve(n-1);
        int step_2=solve(n-2);
        return dp[n]=step_1+step_2;
        }
       
        
}

        
    
