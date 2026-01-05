class Solution {
    public boolean isThree(int n) {
        int count=0;
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
               
                int x=n/i;
                if(i==x){
                    count++;
                }else if(i!=x){
                    count+=2;
                }
            }
            if(count>3){
                break;
            }

        }
    
        if(count==3) return true;
        
        
        return false;
        
    }
}