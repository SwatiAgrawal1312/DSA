class Solution {
    int dp[][];
    public int lengthOfLIS(int[] nums) {
        dp=new int[2501][2501];
         for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        return helper(nums,0,-1);
        
    }
    public int helper(int[] nums,int i,int prev){
       
        if(i>=nums.length){
            return 0;
        }
        if (dp[i][prev + 1] != -1) {
            return dp[i][prev + 1];
        }
        int take=0;
        if(prev==-1||nums[prev]<nums[i]){
           take=1+helper(nums,i+1,i);
        }
        int skip=helper(nums,i+1,prev);
        return dp[i][prev+1]=Math.max(take,skip);
    }
}