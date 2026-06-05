class Solution {
    public int majorityElement(int[] nums) {
        // Boyer-Moore voting algorithm
        int candidate=nums[0];
        int count=1;
        for(int i=1;i<nums.length;i++){
            
            if(nums[i]==candidate){
              count+=1;
            }
            else if(count>0 && nums[i]!=candidate){
                count--;
            }
            else if(count==0 && nums[i]!=candidate){
                candidate=nums[i];
                count++;

            }
            

        }
        // int total=0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==candidate){
        //         total++;
                
        //     }
        // }
        // if(total>nums.length/2){
        //     return candidate;
        // }
        return candidate;
        
    }
}