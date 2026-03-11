class Solution {
    public int bitwiseComplement(int n) {
        int result=0;
        int pow=0;
        if(n==0) return 1;
        while(n>0){
            int x=n&1;
            int flipped=x==0?1:0;
            result+=flipped*(1<<pow);
            pow++;
            n=n>>1;

        }
        return result;
        

        
    }
}