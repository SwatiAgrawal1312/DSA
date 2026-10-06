class Solution {
    public int maxProduct(int[] nums) {
       
        int maxi=Integer.MIN_VALUE;
        int first=1;
        int second=1;
        for(int i=0;i<nums.length;i++){
            first=first*nums[i];
            second=second*nums[nums.length-1-i];
            maxi=Math.max(maxi,Math.max(first,second));
            if(first==0){
               first=1;
            }
            if(second==0){
               second=1;
            }
        }
        return maxi;
        
    }
}