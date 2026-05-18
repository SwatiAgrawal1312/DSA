class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        int res[]=new int[n+1];
        Arrays.fill(res,Integer.MAX_VALUE);
        res[k]=0;
        pq.add(new int[]{0,k});
        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int dist=curr[0];
            int node=curr[1];
           
            for(int i=0;i<times.length;i++){
               int u=times[i][0];
               int v=times[i][1];
               int w=times[i][2];
               if(u==node){
                int ngh=v;
                int d=w;
                int sum=dist+d;
                if(sum<res[ngh]){
                    res[ngh]=sum;
                    pq.add(new int[]{sum,ngh});
                }
               }

            }


        }
       
        
        int max=0;
        for(int i=1;i<=n;i++){
            if(res[i]==Integer.MAX_VALUE){
                return -1;
            }
            max=Math.max(max,res[i]);
        }
        return max;

        
    }
}