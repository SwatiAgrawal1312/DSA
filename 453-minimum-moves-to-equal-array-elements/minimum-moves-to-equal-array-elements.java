class Solution {
    public int minMoves(int[] nums) {
       long min=Long.MAX_VALUE;
       long moves=0;
       for(int i=0;i<nums.length;i++){
        min=Math.min(min,nums[i]);
       }
       for(int i=0;i<nums.length;i++){
        moves+=nums[i]-min;

       }
       return (int)moves;
        
    }

}