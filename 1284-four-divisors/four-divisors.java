class Solution {
    public int sumFourDivisors(int[] nums) {
       
        int finalresult=0;
        for(int i=0;i<nums.length;i++){
            
             int ans=0;
              int count=0;
            for(int j=1;j*j<=nums[i];j++){    //instead of j<=sqrt(nums[i]) 
                if(nums[i]%j==0){
                    int other=nums[i]/j;
                    if(other==j){
                        ans+=j;
                        count+=1;
                    }
                    else{
                        ans+=j+other;
                        count+=2;

                    }
                
                   
                    if(count>4){
                        break;
                    }
                }
            }
                
                if(count==4){
                    finalresult+=ans;
                }
            
        }
        return finalresult;
    }
}