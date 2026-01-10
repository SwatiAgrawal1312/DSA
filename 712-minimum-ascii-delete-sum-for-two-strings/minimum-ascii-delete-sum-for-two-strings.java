class Solution {
    int m,n;
    int dp[][];
    public int minimumDeleteSum(String s1, String s2) {
        m=s1.length();
        n=s2.length();
        dp=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                dp[i][j]=-1;
            }
        }
        return solve(s1,s2,0,0);


        
    }
    private int solve(String s1, String s2,int i,int j){
        //two cases
        if(i>=m && j>=n){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans;
        if(i>=m){
           ans= s2.charAt(j)+solve(s1,s2,i,j+1);
           
        }
        else if(j>=n){
            ans= s1.charAt(i)+solve(s1,s2,i+1,j);


        }
       
        else if(s1.charAt(i)==s2.charAt(j)){
            ans= solve(s1,s2,i+1,j+1);

        }
        else{
        int take_i=s1.charAt(i)+solve(s1,s2,i+1,j);
        int take_j=s2.charAt(j)+solve(s1,s2,i,j+1);
        ans = Math.min(take_i, take_j);
        

        }
        dp[i][j]=ans;
       
        return dp[i][j];
        
    }
}