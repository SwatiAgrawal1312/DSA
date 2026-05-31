class Solution {
    public int[] rearrangeArray(int[] nums) {
        int res[]=new int[nums.length];
        int j=0;
        int k=1;
        for(int x:nums){
            if(x>0){
                res[j]=x;
                j+=2;
                
               

            }else{
                res[k]=x;
                k+=2;
                

            }
            
        }
        return res;
        
    }
}