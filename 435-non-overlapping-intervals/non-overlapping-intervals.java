class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int count=0;
        int curr[]=intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(curr[1]<=intervals[i][0]){
                curr[0]=intervals[i][0];
                curr[1]=intervals[i][1];
            }
            else if(curr[1]>intervals[i][0]){
                count++;
                

            }

        }
        return count;
        
    }
}