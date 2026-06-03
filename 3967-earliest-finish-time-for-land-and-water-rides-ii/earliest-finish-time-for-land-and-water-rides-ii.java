class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        // land->water
        int min=Integer.MAX_VALUE;
        for(int i=0;i<landStartTime.length;i++){
            int sum_duration=landStartTime[i]+landDuration[i];
            min=Math.min(min,sum_duration);

        }
        int res1=Integer.MAX_VALUE;
        for(int j=0;j<waterStartTime.length;j++){
            int choose=Math.max(min,waterStartTime[j]);
            int totalduration=choose+waterDuration[j];
            res1=Math.min(res1,totalduration);

        }
         // water->land
        int mini=Integer.MAX_VALUE;
        for(int s=0;s<waterStartTime.length;s++){
            int sum_duration=waterStartTime[s]+waterDuration[s];
            mini=Math.min(mini,sum_duration);

        }
        int res2=Integer.MAX_VALUE;
        for(int t=0;t<landStartTime.length;t++){
            int choose=Math.max(mini,landStartTime[t]);
            int totalduration=choose+landDuration[t];
            res2=Math.min(res2,totalduration);

        }
       

        return Math.min(res1,res2);
    }
}