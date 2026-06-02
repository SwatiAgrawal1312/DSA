class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        int cs=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            cs+=nums[i];
            
            if(hm.containsKey(cs-k)){
                count+=hm.get(cs-k);
            }
            if(hm.containsKey(cs)){
                hm.put(cs,hm.get(cs)+1);
            }
            else{
                hm.put(cs,1);
            }

        }
        return count;
        
    }
}