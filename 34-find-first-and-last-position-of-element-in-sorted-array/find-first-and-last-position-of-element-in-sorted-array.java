class Solution {
    private int first(int[] nums,int target){
        int i=0;
        int j=nums.length-1;
        int first_occ=-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(nums[mid]==target){
                first_occ=mid;
                j=mid-1;
            }
            else if(nums[mid]<target){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return first_occ;
    }
    private int last(int[] nums,int target){
        int i=0;
        int j=nums.length-1;
        int last_occ=-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(nums[mid]==target){
                last_occ=mid;
                i=mid+1;
            }
            else if(nums[mid]<target){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return last_occ;
    }
    public int[] searchRange(int[] nums, int target) {
        int f=first(nums,target);
        int l=last(nums,target);
        return new int[]{f,l};

        
    }
}