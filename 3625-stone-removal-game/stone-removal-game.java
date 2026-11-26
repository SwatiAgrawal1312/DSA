class Solution {
    public boolean canAliceWin(int n) {
       int val=10;
       int turn=1;
        while(n>=val){
        
           n=n-val;
           turn=1-turn;
          
           val--;
            

        }
        

        return turn==0;
    }
}