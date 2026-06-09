class Solution {
    public long maxTotalValue(int[] nums, int k) {
        

        
            long Max=Long.MIN_VALUE;
            long Min=Long.MAX_VALUE;
            for(int j=0;j<nums.length;j++){
                Max=Math.max(Max,nums[j]);
                Min=Math.min(Min,nums[j]);

            }
           
           
        
        return 1L*k*(Max-Min);
        
    }
}