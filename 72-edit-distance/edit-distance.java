class Solution {
    int m,n;
    int dp[][];
    public int minDistance(String word1, String word2) {
        m=word1.length();
        n=word2.length();
        dp=new int[m+1][n+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return solve(word1,word2,0,0);
        
    }
    private int solve(String s1,String s2,int i,int j){
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(i==s1.length()){
            return n-j;
        }
        else if(j==s2.length()){
            return m-i;
        }
        
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=solve(s1,s2,i+1,j+1);
        }else{

        
        int insert=1+solve(s1,s2,i,j+1);
        int delete=1+solve(s1,s2,i+1,j);
        int replace=1+solve(s1,s2,i+1,j+1);
        return dp[i][j]=Math.min(insert,Math.min(delete,replace));
        
        }
       
        
        
        
    }
}