class Solution {
    int dp[][];
    public int coinChange(int[] coins, int amount) {
       
        dp=new int[coins.length][amount+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);

        }
        int x=helper(coins,amount,coins.length-1);
        return x==Integer.MAX_VALUE?-1:x;
        
        
    }
    public int helper(int[] coins,int amount,int i){
        if(amount==0){
            return 0;
        }
        if(i<0){
            return Integer.MAX_VALUE;
            
        }
       
        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }
        int take=Integer.MAX_VALUE;
        if(coins[i]<=amount){

        int temp=helper(coins,amount-coins[i],i);
        if(temp!=Integer.MAX_VALUE){
            take=1+temp;
        }
        }
        int skip=helper(coins,amount,i-1);
        return dp[i][amount]=Math.min(take,skip);
    }
}