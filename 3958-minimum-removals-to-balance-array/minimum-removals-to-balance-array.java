class Solution {
    public int minRemoval(int[] nums, int k) {
        
        Arrays.sort(nums);
        int maxlength=1;
        int i=0;
        int j=0;
        while(j<nums.length){
            long min=nums[i];
            long max=nums[j];
            while(i<j && max>(long)k*min){

                
               i++;
               min=nums[i];

            }
            maxlength=Math.max(maxlength,j-i+1);
                j++;
        }
        return nums.length-maxlength;
           
    }
}