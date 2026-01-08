class Solution {
    int m,n;
    int dp[][];
    public int maxDotProduct(int[] nums1, int[] nums2) {
        m=nums1.length;
        n=nums2.length;
        dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=Integer.MIN_VALUE;
            }
        }
        return solve(nums1,nums2,0,0);
        
    }
    private int solve(int[] nums1, int[] nums2,int i,int j){
        if(i==m || j==n){
            return -1000000000;
        }
        if(dp[i][j]!=Integer.MIN_VALUE){
           return dp[i][j];
        }
        int val=nums1[i]*nums2[j];
        int bothincr=val+solve(nums1,nums2,i+1,j+1);
        int i_incr=solve(nums1,nums2,i+1,j);
        int j_incr=solve(nums1,nums2,i,j+1);

        dp[i][j]=Math.max(val,Math.max(bothincr,Math.max(i_incr,j_incr)));
        return dp[i][j];

    }
}