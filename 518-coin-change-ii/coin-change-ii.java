class Solution {
    int n;
    int dp[][];
    public int change(int amount, int[] coins) {
        int n=coins.length;
        dp=new int[amount+1][coins.length+1];
        for(int i=0;i<dp.length;i++){
           Arrays.fill(dp[i],-1);
            }
        
        return solve(amount,coins,0);
        
    }
    private int solve(int amount, int[] coins,int i){
        if(amount==0){
            return 1;
        }
        
        if(i==coins.length){
            return 0;

        }
       
        if(dp[amount][i]!=-1){
            return dp[amount][i];
        }
        int take=0;
         if(coins[i]<=amount){
            take=solve(amount-coins[i],coins,i);
         }

        
       
        int skip=solve(amount,coins,i+1);
       return dp[amount][i]= take+skip;
    }
}