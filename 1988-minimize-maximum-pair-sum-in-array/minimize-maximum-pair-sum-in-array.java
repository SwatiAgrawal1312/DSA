class Solution {
    public int minPairSum(int[] nums) {
        int n=nums.length-1;
        Arrays.sort(nums);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length/2;i++){
            int pairsum=nums[i]+nums[n-i];
            max=Math.max(max,pairsum);
        }
        return max;
        
    }
}