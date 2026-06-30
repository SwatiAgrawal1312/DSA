class Solution {
    public int myAtoi(String s) {

        s=s.trim();
        if(s.length()==0){
            return 0;
        }
        int sign=1;
        int j=0;
        if(s.charAt(j)=='+'){
           j++;

        }else if(s.charAt(j)=='-'){
            sign=-sign;
            j++;

        }
        long ans=0;

        for(int i=j;i<s.length();i++){
            char ch=s.charAt(i);
            int x =ch-'0';
            if(x>=0 && x<=9){

                ans=(ans*10)+x;
                
                if(sign==-1 && -ans<=Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }else if(sign==1 && ans>=Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
            }else{
                break;
            }
        }
        return (int)(sign*ans);
        
    }
}