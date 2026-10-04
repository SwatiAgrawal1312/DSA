class Solution {
    public int reverse(int x) {
        long t=0;
        if(x<0){
            t=-x;
        }else{
            t=x;
        }
        
        long ans=0;
        while(t>0){
            long rem=t%10;
           
            ans=ans*10+rem;
            t=t/10;
            

        }
        if(x<0){
            ans=-ans;
        }
        if(ans>Integer.MAX_VALUE  || ans<Integer.MIN_VALUE){
            return 0;
        }
        return (int)ans;
        
    }
}