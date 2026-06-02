class Solution {
    public int maxSubArray(int[] nums) {
        int cs=0;
        int ms=Integer.MIN_VALUE;
        for(int x:nums){
           
            if(cs<0){
                cs=0;
            }
            cs+=x;
            ms=Math.max(ms,cs);
        }
        return ms;
        
    }
}