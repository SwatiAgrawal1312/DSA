class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        int n=nums.length;
       
        min=Math.min(nums[n-2]-nums[1],Math.min(nums[n-1]-nums[2],nums[n-3]-nums[0]));
        return min;

        
    }
}