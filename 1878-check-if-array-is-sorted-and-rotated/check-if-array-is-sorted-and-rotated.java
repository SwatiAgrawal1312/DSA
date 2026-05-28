class Solution {
    public boolean check(int[] nums) {
        int pivot=-1;
        int count=0;
       for(int i=0;i<nums.length-1;i++){
        if(nums[i]>nums[i+1]){
            pivot=i;
            count++;
        }

       }
       if(count>1){
        return false;
       }
       if(pivot==-1){
        return true;
       }
        return nums[nums.length - 1] <= nums[0];

        
        
    }
}