class Solution {
    int dp[][]=new int[2500][2501];
    public int lengthOfLIS(int[] nums) {
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        return solver(nums,0,-1);
        
    }
    public int solver(int nums[],int i,int prev){
        if(i==nums.length){
            return 0;
        }
        if(dp[i][prev+1]!=-1){
            return dp[i][prev+1];
        }
        int take=0;
        if(prev==-1||nums[prev]<nums[i]){
            take=1+solver(nums,i+1,i);

        }
        int skip=solver(nums,i+1,prev);
        return dp[i][prev+1]=Math.max(take,skip);
    }
}