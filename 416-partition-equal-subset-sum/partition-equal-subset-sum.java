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
        dp=new Boolean[201][target+1];
       
        
        return solve(nums,target,0);
    }
    public boolean solve(int[] nums,int s,int i){
        if(s==0){
            return true;
        }
        if(i>=nums.length){
            return false;
        }
        if(dp[i][s]!=null){
            return dp[i][s];
        }
        boolean take=false;
       if(s>=nums[i]){
         take=solve(nums,s-nums[i],i+1);
       }

       
       
       boolean skip=solve(nums,s,i+1);
       return dp[i][s]=take||skip;



    }
}