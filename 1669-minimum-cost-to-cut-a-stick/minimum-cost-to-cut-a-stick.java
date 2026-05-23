
class Solution {
    int dp[][];
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        int arr[]=new int[m+2];
        arr[0]=0;
        arr[arr.length-1]=n;
        for(int i=0;i<cuts.length;i++){
            arr[i+1]=cuts[i];
        }
        Arrays.sort(arr);
        dp=new int[m+2][m+2];
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        return solver(arr,1,m);

        
    }
    public int solver(int arr[],int l,int r){
        if(l>r){
            return 0;
        }
        if(dp[l][r]!=-1){
            return dp[l][r];
        }
        int mini=Integer.MAX_VALUE;
        for(int k=l;k<=r;k++){
            int cost=arr[r+1]-arr[l-1]+solver(arr,l,k-1)+solver(arr,k+1,r);
            mini=Math.min(cost,mini);
        }
        return dp[l][r]=mini;
    }
}