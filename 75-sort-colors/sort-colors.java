class Solution {
    public void sortColors(int[] nums) {
        int mid=0;
        int i=0;
        int j=nums.length-1;
        while(mid<=j){
           
             if(nums[mid]==2){
                  int temp=nums[mid];
                  nums[mid]=nums[j];
                  nums[j]=temp;
                
                j--;



            }else if(nums[mid]==0){
                int temp=nums[mid];
                  nums[mid]=nums[i];
                  nums[i]=temp;
                  i++;
                  mid++;
                  

            }else {
                mid++;

            }
          

        }
       
        
    }
}