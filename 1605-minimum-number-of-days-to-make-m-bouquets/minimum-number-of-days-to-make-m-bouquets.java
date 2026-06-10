class Solution {
    public boolean  check(int[] bloomDay,int target,int k,int m){
        int s=0;
        int ans=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=target){
                s++;
            }else{
                s=0;
            }
            if(s==k){
                ans++;
                s=0;
            }
        }
        return ans>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int i=1;
        int j=Integer.MIN_VALUE;
        for(int a=0;a<bloomDay.length;a++){
            j=Math.max(j,bloomDay[a]);
        }
        int min_days=-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            boolean x=check(bloomDay,mid,k,m);
                if(x==true){
                    min_days=mid;
                    j=mid-1;


                }else{
                    i=mid+1;
                }
            
        }
        return min_days;
    }
}