class Solution {
    public int repeatedNTimes(int[] nums) {
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            if((i>=1 && nums[i]==nums[i-1]) ||( i>=2 && nums[i]==nums[i-2])){
                return nums[i];

            }
        }
        return nums[nums.length-1];
        
    }
}