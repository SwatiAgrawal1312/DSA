class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int result[]=new int[nums.size()];
       
        for(int i=0;i<nums.size();i++){
            
            if(nums.get(i)==2){
                result[i]=-1;
                continue;
               
            }
            boolean found=false;
           
            for(int j=0;j<32;j++){
                if((nums.get(i)&(1<<j))>0){
                    continue;
                }
                int prev=j-1;
                int x=nums.get(i)^(1<<prev);
                result[i]=x;
                found=true;
                break;
                
            }
            if(found==false){
            result[i]= -1;
            }
    }
    return result;
        
       
    
        
    }
}