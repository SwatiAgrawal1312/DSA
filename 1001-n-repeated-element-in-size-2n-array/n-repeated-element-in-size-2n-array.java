class Solution {
    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> hm=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(hm.contains(nums[i])){
                return nums[i];
            }else{
                hm.add(nums[i]);
            }
        }
        return -1;
        
    }
}