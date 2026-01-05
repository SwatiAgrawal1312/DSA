class Solution {
    public void rotate(int[] nums, int k) {
        int result[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int x=i+k;
            result[x%nums.length]=nums[i];
        }
       for(int i=0;i<nums.length;i++){
        nums[i]=result[i];

       }
        
    }
}