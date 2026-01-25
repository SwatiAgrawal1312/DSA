class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int mini=Integer.MAX_VALUE;
        int i=0;
        int j=k-1;

        while(j<nums.length){
            int min=nums[i];
            int max=nums[j];
          
            mini=Math.min(mini,max-min);
            i++;
            j++;

        }
        return mini;
        }
}