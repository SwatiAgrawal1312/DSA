class Solution {
    int dp[][]=new int[501][501];
    public int minInsertions(String s) {
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        return solver(s,0,s.length()-1);
        
    }
    public int solver(String s,int i,int j){
        if(j<i){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=solver(s,i+1,j-1);
        }
        int inc_i=1+solver(s,i+1,j);
        int dec_j=1+solver(s,i,j-1);
        return dp[i][j]=Math.min(inc_i,dec_j);
    }
}