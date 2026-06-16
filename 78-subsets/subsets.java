class Solution {
     List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
       
         helper(nums,0,new ArrayList<>());
         return res;
        
    }
    public void helper(int nums[],int i,List<Integer> curr){
        if(i==nums.length){
            res.add(new ArrayList(curr));
            return;
        }
        curr.add(nums[i]);
        helper(nums,i+1,curr);

        curr.remove(curr.size()-1);
        helper(nums,i+1,curr);
    }
        
}