class Solution {
    int dp[][];
    public int minInsertions(String s) {
        int n=s.length();
        dp=new int[n][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return insert(s,0,s.length()-1);
        
    }
    public int insert(String s,int i,int j){
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=insert(s,i+1,j-1);
        }
        int x=1+insert(s,i+1,j);
        int y=1+insert(s,i,j-1);
        return dp[i][j]=Math.min(x,y);
    }
}