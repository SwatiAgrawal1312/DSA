class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        // land->water
        int res1=Integer.MAX_VALUE;
        for(int i=0;i<landStartTime.length;i++){
            int land=landStartTime[i]+landDuration[i];
            for(int j=0;j<waterStartTime.length;j++){
                int waterstarttime=waterStartTime[j];
                int choose=Math.max(land,waterstarttime);
                int finishslide=choose+waterDuration[j];
                res1=Math.min(res1,finishslide);

            }
        }
        // water->land
        int res2=Integer.MAX_VALUE;
        for(int s=0;s<waterStartTime.length;s++){
            int water=waterStartTime[s]+waterDuration[s];
            for(int t=0;t<landStartTime.length;t++){
                int land=landStartTime[t];
                int choose=Math.max(land,water);
                int finishslide=choose+landDuration[t];
                res2=Math.min(res2,finishslide);

            }
        }
        return Math.min(res1,res2);
        
    }
}