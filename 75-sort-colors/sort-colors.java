class Solution {
    public void sortColors(int[] nums) {
        int i=0;
        int mid=0;
        int j=nums.length-1;
        while(mid<=j){
            if(nums[mid]==2){
                swap(nums,mid,j);
                j--;
               
         
            }
            else if(nums[mid]==0){
                swap(nums,mid,i);
                i++;
                mid++;


            }else{
                mid++;

            }
        }

        
    }
    public void swap(int nums[],int x,int y){
        int temp=nums[x];
        nums[x]=nums[y];
        nums[y]=temp;
    }
}