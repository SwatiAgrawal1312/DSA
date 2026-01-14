class Solution {
    
   int dp[];
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        dp=new int[101];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        int case1= solve(nums,0,n-2);
        dp=new int[101];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        int case2=solve(nums,1,n-1);
        return Math.max(case1,case2);
        
    }
    public int solve(int[] nums,int i,int n){
        if(i>n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int take=nums[i]+solve(nums,i+2,n);
        int not_take=solve(nums,i+1,n);
        return dp[i]=Math.max(take,not_take);
        
    }
}