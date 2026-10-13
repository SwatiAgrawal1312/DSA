class Solution {
    public long maxAlternatingSum(int[] nums) {
    for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
    }
    Arrays.sort(nums);
    long sum=0;
   
    int n=nums.length/2;
    for(int i=0;i<n;i++){
        sum-=nums[i];
       
    }
    for(int i=n;i<nums.length;i++){
       
        sum+=nums[i];
    }
    
    return sum;
    }
}





















