class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates,0,target,new ArrayList<>());
        return res;
        
    }
    public void helper(int candidates[],int index,int target,List<Integer> curr){
       
        if(target==0){
            res.add(new ArrayList(curr));
            return;
        }
     for(int i=index;i<candidates.length;i++){
        if(i>index && candidates[i]==candidates[i-1]){
            continue;
        }
        if(candidates[i]>target){
            break;
        }
        curr.add(candidates[i]);
        helper(candidates,i+1,target-candidates[i],curr);
        curr.remove(curr.size()-1);
     }

    }
}