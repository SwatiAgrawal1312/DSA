class Solution {
    Integer[][] dp;

    public int coinChange(int[] coins, int amount) {
       dp=new Integer[coins.length][amount+1];
        int result=solve(coins,amount,coins.length-1);
        return result==Integer.MAX_VALUE?-1:result;
        
    }
    public int solve(int[] coins,int amount,int i){
        if(amount==0){
            return 0;
        }
        if(i<0){
            return Integer.MAX_VALUE;
        }
        if(dp[i][amount]!=null){
            return dp[i][amount];
        }
        int take=Integer.MAX_VALUE;
        if(coins[i]<=amount){
            take=solve(coins,amount-coins[i],i);
            if(take!=Integer.MAX_VALUE){
                take=1+take;
            }
        }
       int skip=solve(coins,amount,i-1);
        return dp[i][amount]=Math.min(take,skip);
    }
}