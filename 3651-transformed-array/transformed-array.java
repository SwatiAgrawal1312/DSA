class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int[] result=new int[n];
         
        for(int i=0;i<n;i++){
           int shift=nums[i]%n;
           int j=(i+shift)%n;
           
            if(j<0){
                j=j+n;


           }
           result[i]=nums[j];
        }
        return result;
        
    }
}