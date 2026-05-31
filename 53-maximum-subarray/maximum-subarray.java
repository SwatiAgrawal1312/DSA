class Solution {
    public int maxSubArray(int[] nums) {
        int cs=0;
        int ms=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            
            if(cs<0){
                cs=0;
            }
            cs+=nums[i];
            ms=Math.max(ms,cs);


        }
        return ms;
        
    }
}