class Solution {
    public int[] shuffle(int[] nums, int n) {
        int result[]=new int[nums.length];
        int s=0;
        int t=n;
        
        for(int i=0;i<result.length;i++){
            if(i%2==0){
                result[i]=nums[s++];
            }else{
                result[i]=nums[t++];
            }

        }
        return result;
        
    }
}