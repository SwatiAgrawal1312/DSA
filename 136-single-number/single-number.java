class Solution {
    public int singleNumber(int[] nums) {
        
        HashMap<Integer,Integer> hm=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i],hm.get(nums[i])+1);
            }else{
                hm.put(nums[i],1);
            }

        }
        for(int x:hm.keySet()){
            if(hm.get(x)==1){
                return x;
            }
        }
        return -1;

        
    }
}