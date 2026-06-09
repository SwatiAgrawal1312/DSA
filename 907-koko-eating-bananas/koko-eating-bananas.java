class Solution {
    public int find_minhrs(int piles[],int mid){
        int min_hrs=0;
            for(int i=0;i<piles.length;i++){
                min_hrs+=Math.ceil((double)piles[i]/mid);
            }
            return min_hrs;

    }
    public int minEatingSpeed(int[] piles, int h) {
        int i=1;
        int j=Integer.MIN_VALUE;
        
        for(int k=0;k<piles.length;k++){
            j=Math.max(j,piles[k]);
        }
        int res=j;
        while(i<=j){
            int mid=i+(j-i)/2;
            int hours=find_minhrs(piles,mid);
            if(hours<=h){
                res=mid;
                j=mid-1;

            }
            else{
                i=mid+1;

            }
            
        }
        return res;
        
    }
}