class Solution {
    public int longestBalanced(int[] nums) {
        Set<Integer> even;
        Set<Integer> odd;
        int result=0;
        for(int i=0;i<nums.length;i++){
            even=new HashSet<>();
            odd=new HashSet<>();
            int j=i;
            while(j<nums.length){
            
            if(nums[j]%2==0){
                even.add(nums[j]);
            }else{
                odd.add(nums[j]);
            }
            if(even.size()==odd.size()){
               result=Math.max(result,j-i+1);
            }
            j++;
            }
            

        }
        return result;
        
    }
}