class Solution {
    public int maxLength(int[] nums) {
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int prod=1;
            int GCD=nums[i];
            int LCM=nums[i];
            for(int j=i;j<nums.length;j++){
                prod*=nums[j];
                GCD=findgcd(GCD,nums[j]);
                LCM=findlcm(LCM,nums[j]);
                if(prod==GCD*LCM){
                    maxi=Math.max(maxi,j-i+1);
                }


            }
        }
        return maxi;
        
    }
    public int findgcd(int a,int b){
        while(b!=0){
            int rem=a%b;
            a=b;
            b=rem;
        }
        return a;
    }
    public int findlcm(int a,int b){
        return (int)a*b/findgcd(a,b);
    }
}