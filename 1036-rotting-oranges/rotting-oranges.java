class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int direction[][]={{0,1},{1,0},{0,-1},{-1,0}};
        int m=grid.length;
        int n=grid[0].length;
        int freshcount=0;
        int minute=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                   q.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    freshcount++;

                }
            }
        }
        if(freshcount==0){
            return 0;
        }
        while(!q.isEmpty()){
            int sz=q.size();
            for(int i=0;i<sz;i++){
            int curr[]=q.poll();
            int r=curr[0];
            int c=curr[1];
            for(int x[]:direction){
                int new_r=r+x[0];
                int new_c=c+x[1];
                if(new_r>=0 && new_r<m && new_c>=0 && new_c<n && grid[new_r][new_c]==1){
                    grid[new_r][new_c]=2;
                    q.offer(new int[]{new_r,new_c});
                    freshcount--;


                }
            }
            }
            minute++;

        }
        return freshcount==0?minute-1:-1;

    }
}