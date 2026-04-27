class Solution {
    int dp[][];
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        dp=new int[1000][1001];
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        return helper(pairs,0,-1);
        
    }
    public int helper(int[][] pairs,int curr_idx,int prev_idx){
        if(curr_idx==pairs.length){
            return 0;
        }
        if(dp[curr_idx][prev_idx+1]!=-1){
            return dp[curr_idx][prev_idx+1];
        }
        int skip=helper(pairs,curr_idx+1,prev_idx);
        int take=0;
        if(prev_idx==-1 || pairs[prev_idx][1]<pairs[curr_idx][0]){
            take=1+helper(pairs,curr_idx+1,curr_idx);

        }
        return dp[curr_idx][prev_idx+1]=Math.max(skip,take);

    }
}