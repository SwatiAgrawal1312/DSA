class Solution {
  
    public int firstStableIndex(int[] nums, int k) {
        int maxi[]=new int[nums.length];
        maxi[0]=nums[0];
        for(int i=1;i<nums.length;i++){
           maxi[i]=Math.max(nums[i],maxi[i-1]);
        }

        int mini[]=new int[nums.length];
        mini[nums.length-1]=nums[nums.length-1];
        for(int j=nums.length-2;j>=0;j--){
            mini[j]=Math.min(nums[j],mini[j+1]);
        }
        for(int s=0;s<nums.length;s++){
            int instability=maxi[s]-mini[s];
            if(instability<=k){
                return s;
            }
        }
        return -1;
        
    }

}