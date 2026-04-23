class Solution {
    int dp[];
    public int fib(int n) {
        dp=new int[31];
        Arrays.fill(dp,-1);
        if(n==0 || n==1){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
    int res=fib(n-1)+fib(n-2);
    return dp[n]=res;
    }

}