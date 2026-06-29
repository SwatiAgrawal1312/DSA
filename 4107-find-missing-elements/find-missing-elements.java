class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        Arrays.sort(nums);
        int start=nums[0];
        int end=nums[nums.length-1];
        for(int i=start;i<=end;i++){
            if(!hs.contains(i)){
                list.add(i);

            }
        }
        return list;


        
    }
}