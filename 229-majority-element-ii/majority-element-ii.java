class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i],hm.get(nums[i])+1);
            }else{
                hm.put(nums[i],1);
            }
        }
        for(int x:hm.keySet()){
        if(hm.get(x)>nums.length/3){
            res.add(x);

        }
        }
        return res;
        
    }
    
}