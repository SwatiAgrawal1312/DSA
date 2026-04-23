class Solution {
    
    long dp[][];
    
    public long maxAlternatingSum(int[] nums) {
        dp=new long[100001][2];
        for(long[] row:dp){
            Arrays.fill(row,-1);
        }

        return solve(nums,0,true);
    }
    public long solve(int[] nums,int i,boolean flag){
        if(i>=nums.length){
            return 0;
        }
        int f=flag?1:0;
        if(dp[i][f]!=-1){
            return dp[i][f];
        }
        long skip=solve(nums,i+1,flag);
        long value=nums[i];
        if(flag!=true){
            value=-value;
        }
        long take=solve(nums,i+1,!flag)+value;
        return dp[i][f]=Math.max(take,skip);
    }
}