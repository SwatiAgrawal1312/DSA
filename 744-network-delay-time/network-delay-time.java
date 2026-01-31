class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int result[]=new int[n+1];
        Arrays.fill(result,Integer.MAX_VALUE);
        result[k]=0;
        PriorityQueue<int []>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        ArrayList<int []>[] adj=new ArrayList[n+1];
        for(int i=1;i<n+1;i++){
            adj[i]=new ArrayList<>();

        }
        for(int i=0;i<times.length;i++){
            int x[]=times[i];
            int u=x[0];
            int v=x[1];
            int w=x[2];
            adj[u].add(new int[]{v,w});


        }
        pq.offer(new int[]{0,k});
        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int d=curr[0];
            int nodes=curr[1];
            for(int a[]:adj[nodes]){
                int ngbr=a[0];
                int dist=a[1];
                if(d+dist<result[ngbr]){
                    result[ngbr]=d+dist;
                    pq.offer(new int[]{d+dist,ngbr});
                }
            }


        }
        int maxy=Integer.MIN_VALUE;
        for(int i=1;i<result.length;i++){
            if(result[i]==Integer.MAX_VALUE){
                return -1;
            }
            maxy=Math.max(maxy,result[i]);
        }
        return maxy;

        
    }
}