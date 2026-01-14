class Solution {
    int n;
    int dp[];
    public int rob(int[] nums) {
        n=nums.length;
        dp=new int[101];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        return solve(nums,0);
        
    }
    public int solve(int[] nums,int i){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int take=nums[i]+solve(nums,i+2);
        int not_take=solve(nums,i+1);
        return dp[i]=Math.max(take,not_take);
    }
}