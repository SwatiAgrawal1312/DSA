class Solution {
    int count=0;
    public int findTargetSumWays(int[] nums, int target) {
        solver(nums,target,0,0);
        return count;

        
    }
    public void solver(int nums[],int target,int i,int sum){
        if(i>=nums.length){
            if(sum==target){
                count++;
            }
            return;
        }
        solver(nums,target,i+1,sum+nums[i]);
        solver(nums,target,i+1,sum-nums[i]);
        
    }
}