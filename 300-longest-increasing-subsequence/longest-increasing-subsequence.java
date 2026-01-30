class Solution {
    int dp[][];
    int n;
    public int lengthOfLIS(int[] nums) {
        n=nums.length;
        dp=new int[n+1][n+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp.length;j++){
                dp[i][j]=Integer.MIN_VALUE;
            }
        }
       
        return solve(nums,-1,0);
        
        
    }
    public int solve(int[] nums,int p,int i){
        if(i>=n){
            return 0;
        }
        int x=0;
        if(dp[p+1][i]!=Integer.MIN_VALUE){
            return dp[p+1][i];
        }
        if(p==-1||nums[p]<nums[i]){
            x=1+solve(nums,i,i+1);
        }
        int y=solve(nums,p,i+1);
        return dp[p+1][i]=Math.max(x,y);
    }
}