class Solution {
    public boolean isTrionic(int[] nums) {
        int n=nums.length;
        if(n<3){
            return false;
        }
        int i=0;
        while(i+1<nums.length && nums[i]<nums[i+1]){
            i++;

        }
        if(i==0 || i==nums.length-1){
            return false;
        }
        while(i+1<nums.length && nums[i]>nums[i+1]){
            i++;
        }
        if(i==nums.length-1){
            return false;
        }
        while(i+1<nums.length && nums[i]<nums[i+1]){
            i++;

        }
        if(i==nums.length-1){
            return true;
        }
        return false;

        
    }
}