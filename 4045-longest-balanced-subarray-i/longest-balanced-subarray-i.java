class Solution {
    public int longestBalanced(int[] nums) {
       
        int result=0;
        for(int i=0;i<nums.length;i++){
            Set<Integer> even=new HashSet<>();
            Set<Integer> odd=new HashSet<>();
            int j=i;
            while(j<nums.length){
            
            if(nums[j]%2==0) even.add(nums[j]);
            else odd.add(nums[j]);
            
            if(even.size()==odd.size()) result=Math.max(result,j-i+1);
            
            j++;
            }
            

        }
        return result;
        
    }
}