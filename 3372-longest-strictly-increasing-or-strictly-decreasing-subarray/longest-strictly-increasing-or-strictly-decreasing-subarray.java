class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        // increasing
        int maxi=1;
        int count=1;
        for(int i=1;i<nums.length;i++){
          if(nums[i-1]<nums[i]){
            count++;
          }
          else{
            count=1;
          }
          maxi=Math.max(count,maxi);

        }
        
         // decreasing
        int maxi2=1;
        int count2=1;
        for(int i=1;i<nums.length;i++){
          if(nums[i-1]>nums[i]){
            count2++;
          }
          else{
            count2=1;
          }
          maxi2=Math.max(count2,maxi2);

        }
        return Math.max(maxi,maxi2);
        
        
    }
}