class Solution {
    public void nextPermutation(int[] nums) {
        int gola_point=-1;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                gola_point=i-1;
                break;

            }
        }
            if(gola_point==-1){
            reverse(nums,0,nums.length-1);
            return;
            }
            int swap_point=nums.length-1;
            while(nums[gola_point]>=nums[swap_point]){
                swap_point--;
            }
            swap(nums,gola_point,swap_point);
            reverse(nums,gola_point+1,nums.length-1);
        }
        
    
    public void swap(int nums[],int i,int j ){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        public void reverse(int nums[],int i,int j){
            while(i<j){
            swap(nums,i,j);
            i++;
            j--;

            }
        }
}