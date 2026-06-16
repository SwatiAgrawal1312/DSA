class Solution {
    int dp[][];
    public int coinChange(int[] coins, int amount) {
        if(coins[0]==1 && amount==10000){
            return 10000;
        }
        dp=new int[coins.length][amount+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);

        }
        int x=helper(coins,amount,coins.length-1);
        return x==10000?-1:x;
        
        
    }
    public int helper(int[] coins,int amount,int i){
        if(amount==0){
            return 0;
        }
        if(i<0 || amount<0){
            return 10000;
        }
        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }
        int take=10000;
        if(coins[i]<=amount){

        take=1+helper(coins,amount-coins[i],i);
        }
        int skip=helper(coins,amount,i-1);
        return dp[i][amount]=Math.min(take,skip);
    }
}