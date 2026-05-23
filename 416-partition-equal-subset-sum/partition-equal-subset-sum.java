class Solution {
    Boolean dp[][];
    public boolean canPartition(int[] nums) {
        int s=0;
        for(int i=0;i<nums.length;i++){
            s+=nums[i];

        }
        if(s%2!=0){
            return false;
        }
        int target=s/2;
        dp=new Boolean[nums.length][target+1];
        return solve(nums,0,target);
        
    }
    public boolean solve(int nums[],int idx,int target){
        if(target==0){
            return true;
        }
        if(idx>=nums.length){
            return false;
        }
        if(dp[idx][target]!=null){
            return dp[idx][target];
        }
        boolean take=false;
        if(target>=nums[idx]){
            take=solve(nums,idx+1,target-nums[idx]);
        }
        boolean skip=solve(nums,idx+1,target);
        return dp[idx][target]=take||skip;
    }
    
} 