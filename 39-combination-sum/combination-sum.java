class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       
        helper(candidates,0,new ArrayList<>(),target);
        return res;
    }
    public void helper(int[] candidates,int i,List<Integer> curr, int target){
        if(i==candidates.length || target<0){
            return;
        }
        if(target==0){
            res.add(new ArrayList(curr));
            return;
        }
        curr.add(candidates[i]);
        helper(candidates,i,curr,target-candidates[i]);

        curr.remove(curr.size()-1);
        helper(candidates,i+1,curr,target);

    }
}