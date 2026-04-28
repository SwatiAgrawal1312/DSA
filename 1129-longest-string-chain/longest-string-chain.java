class Solution {
    int dp[][];
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->(a.length()-b.length()));
        dp=new int[1000][1001];
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        
        return helper(words,0,-1);
        
    }
   
    public int helper(String[] words,int curr_idx,int prev_idx ){
        if(curr_idx==words.length){
            return 0;
        }
        if(dp[curr_idx][prev_idx+1]!=-1){
            return dp[curr_idx][prev_idx+1];
        }
        int skip=helper(words,curr_idx+1,prev_idx);
        int take=0;
        if(prev_idx==-1 || ispredecessor(words[prev_idx],words[curr_idx])){
            take=1+helper(words,curr_idx+1,curr_idx);
        }
        return dp[curr_idx][prev_idx+1]=Math.max(skip,take);

    }
    public boolean ispredecessor(String st1,String st2){
        int m=st1.length();
        int n=st2.length();
        if(n-m!=1){
            return false;
        }
        int i=0;
        int j=0;
        while(i<m && j<n){
            if(st1.charAt(i)==st2.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }
        
        return i==m;

    }
}