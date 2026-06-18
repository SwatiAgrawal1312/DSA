class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        helper(nums,0,res);
        return res;
        
        
    }
    public void helper(int[] nums,int idx,List<List<Integer>> res){
        if(idx==nums.length){
            List<Integer> curr=new ArrayList<>();
            for(int num:nums){
                curr.add(num);
            }
            res.add(curr);
            return;

           
        }
        for(int i=idx;i<nums.length;i++){
            swap(nums,idx,i);
            helper(nums,idx+1,res);
            swap(nums,idx,i);

        }
    }
    public void swap(int nums[],int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}