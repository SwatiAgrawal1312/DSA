class Solution {
    public int[][] merge(int[][] intervals) {
        // sorting based on 0 index
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        ArrayList<int[]> res=new ArrayList<>();
        int[] current=intervals[0];
        for(int i=1;i<intervals.length;i++){
            int val[]=intervals[i];
            if(val[0]<=current[1]){
                current[1]=Math.max(current[1],val[1]);
            
            }else{
                res.add(current);
                current=val;

            }
           
        }
        res.add(current);
        return res.toArray(new int[res.size()][]);
        
       


        
        
    }
}