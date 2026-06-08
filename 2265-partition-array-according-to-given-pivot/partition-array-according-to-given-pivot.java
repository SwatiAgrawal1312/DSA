class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int res[]=new int[nums.length];
        int k=0;
        // <pivot
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot){
                res[k]=nums[i];
                k++;
            }

        }
        // =pivot
         for(int i=0;i<nums.length;i++){
             if(nums[i]==pivot){
                res[k]=nums[i];
                k++;
            }

        }
        // >pivot
         for(int i=0;i<nums.length;i++){
             if(nums[i]>pivot){
                res[k]=nums[i];
                k++;
            }

        }
        return res;

        
    }
}