class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        helper(0,nums,new ArrayList<>(),res);
        return res;
        
    }
    public void helper(int index,int nums[],List<Integer> curr,List<List<Integer>> res){
        res.add(new ArrayList<>(curr));
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }
            curr.add(nums[i]);
            helper(i+1,nums,curr,res);
            curr.remove(curr.size()-1);
        }
    }
}