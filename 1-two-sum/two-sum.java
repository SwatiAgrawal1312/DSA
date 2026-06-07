class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int remaining=target-nums[i];
            if(hm.containsKey(remaining)){
                return new int[]{hm.get(remaining),i};
            }else{
                hm.put(nums[i],i);
            }
        }
        return new int[]{};
        
    }
}