class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        int count=nums.length;
       
        for(int i=0;i<nums.length;i++){
            if(nums[i]>target){
                count=i;
                break;
            }
               

               
            
        }
        for(int i=0;i<count;i++){
            if(nums[i]==target){
                list.add(i);
            }
        }
        return list;
        
    }
}