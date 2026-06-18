class Solution {
    public List<List<Integer>> permute(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        List<List<Integer>> res=new ArrayList<>();
        helper(nums,hs,new ArrayList<>(),res);
        return res;
        
        
    }
    public void helper(int[] nums,HashSet<Integer> hs,List<Integer> curr,List<List<Integer>> res){
        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++){
           if(hs.contains(nums[i])){
            continue;
           }
           hs.add(nums[i]);
           curr.add(nums[i]);
           helper(nums,hs,curr,res);
           curr.remove(curr.size()-1);
           hs.remove(nums[i]);
           

        }
    }
}